package cn.ali.common.http;

import cn.ali.common.response.ResponseEnum;
import cn.ali.common.response.ResponseResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class HttpClientHelper {
    @Autowired
    private HttpServletRequest request;
    private ObjectMapper objectMapper = new ObjectMapper();

    public HttpClientHelper(HttpServletRequest request) {
        this.request = request;
    }

    /**
     * 访问单点登录的其他模块的api
     *
     * @param uri
     * @return
     */
    public ResponseResult getForResponse(String uri, Map<String, Object> params) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        CloseableHttpResponse response = null;
        HttpGet httpGet = null;
        try {
            String ssoCookies = (String) request.getAttribute("ssoCookies");
            URIBuilder uriBuilder = new URIBuilder(uri);
            /** 第一种添加参数的形式 */
            Set<String> keySet = params.keySet();
            for (String key : keySet) {
                uriBuilder.addParameter(key, ""+params.get(key));
            }
            httpGet = new HttpGet(uriBuilder.build());
            httpGet.addHeader("Cookie", ssoCookies);
            response = httpClient.execute(httpGet);
            HttpEntity httpEntity = response.getEntity();
            //授权过期,需要用户重新授权
            Header contentType = (Header) response.headerIterator("Content-Type").next();
            if (contentType.getValue().startsWith("text/html")) {//请求授权页面
                return new ResponseResult(ResponseEnum.ERROR).setResponseBody("调用目标的授权已经失效，请先重新获取授权<a href='" + uri + "'>授权</a>");
            }
            String result = null;
            if (httpEntity != null) {
                result = EntityUtils.toString(httpEntity);
//				if(log.isDebugEnabled()) {
//					log.debug("响应内容：{}",result);
//				}
                if (response.getStatusLine().getStatusCode() == 200) {
                    ResponseResult result1 = objectMapper.readValue(result, ResponseResult.class);
                    return result1;
//					return new ResponseResult(ResponseEnum.SUCCESS).setResponseBody(result);
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
//			log.error(ex.getMessage(),ex);
        } finally {
            HttpClientUtils.closeQuietly(httpClient);
            HttpClientUtils.closeQuietly(response);
        }
        return new ResponseResult(ResponseEnum.ERROR).setResponseBody("出错了");
    }

    /**
     * 普通http请求
     *
     * @param uri
     * @return
     */
    public String get(String uri) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        CloseableHttpResponse response = null;
        String result = null;
        try {
            HttpGet httpGet = new HttpGet(uri);
            response = httpClient.execute(httpGet);
            result = EntityUtils.toString(response.getEntity());
        } catch (Exception ex) {
//			log.error(ex.getMessage(),ex);
        } finally {
            HttpClientUtils.closeQuietly(httpClient);
            HttpClientUtils.closeQuietly(response);
        }
        return result;
    }

    /**
     * 普通http请求
     *
     * @param uri
     * @return
     */
    public String post(String uri) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        CloseableHttpResponse response = null;
        String result = null;
        try {
            HttpPost httpPost = new HttpPost(uri);
            response = httpClient.execute(httpPost);
            result = EntityUtils.toString(response.getEntity());
        } catch (Exception ex) {
//			log.error(ex.getMessage(),ex);
        } finally {
            HttpClientUtils.closeQuietly(httpClient);
            HttpClientUtils.closeQuietly(response);
        }
        return result;
    }

    /**
     * 访问单点登录的其他模块的api
     *
     * @param uri
     * @return
     */
    public ResponseResult postForResponse(String uri, Map<String, Object> params, String originServerUrl) {
        String ssoCookies = (String) request.getAttribute("ssoCookies");
        Assert.hasLength(ssoCookies, "ssoCookies not found!");
        //移除本机的csrf令牌值(csrftoken只能用在post提交到本机的操作)
        StringBuffer requiredValues = new StringBuffer();
        String[] tmp = ssoCookies.split(";");
        for (String value : tmp) {
            if (value.indexOf("TOKEN") == -1) {
                requiredValues.append(value).append(";");
            }
        }
        ssoCookies = requiredValues.toString();
        //Post请求默认不触发oauth2认证请求，先发一个head请求到目标服务器(带上本机的局部sessionid)
        //取回单点登录目标机的局部sessionid,用在后续的Post请求中标识身份
        //同时还取回了目标机的csrf令牌
        URI serverUrl = URI.create(uri);
        HttpHead httpHead = new HttpHead("http://" + serverUrl.getHost() + ":" + serverUrl.getPort());
        httpHead.setHeader("Cookie", ssoCookies);
        List<Cookie> cookies = this.doHead(httpHead);
        String targetCsrfToken = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().toLowerCase().indexOf("token") != -1) {
                targetCsrfToken = cookie.getValue();
            }
            //加到cookie向目标机表明身份
            ssoCookies += cookie.getName() + "=" + cookie.getValue() + ";";
        }
        Assert.hasLength(targetCsrfToken, "not found csrfToken");
        //发送post请求，加上本机的局部sessionid和目标机的sessionid()
        HttpPost httpPost = new HttpPost(uri);
        httpPost.setHeader("X-CSRF-TOKEN", targetCsrfToken);//令牌加入到请求头
        httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:75.0) Gecko/20100101 Firefox/75.0");
        httpPost.setHeader("Cookie", ssoCookies);
        params.put("_csrf", targetCsrfToken);//令牌加入到请求参数（头和参数二选一就行，都加更保险）
        //不需要再配置信任列表了
		/*if (originServerUrl != null) {
			// 被调用服务器的spring security csrf过滤器默认会阻止post跨站访问
			// 在被调用的服务器配置文件中加入了信任的主机地址
			httpPost.setHeader(CusomCsrfMatcher.HEADER_NAME, originServerUrl);
		}*/
        if (params != null) {
            List<NameValuePair> nameValuePairs = new ArrayList<>();
            params.forEach((k, v) -> {
                if (v != null) {
                    nameValuePairs.add(new BasicNameValuePair(k, v.toString()));
                }
            });
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, StandardCharsets.UTF_8));
        }
        return this.execute(httpPost);
    }

    private List<Cookie> doHead(HttpRequestBase requestBase) {
        CookieStore cookieStore = new BasicCookieStore();
        CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultCookieStore(cookieStore).build();
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(requestBase);
            return cookieStore.getCookies();
        } catch (Exception ex) {
//			log.error(ex.getMessage(), ex);
        } finally {
            HttpClientUtils.closeQuietly(httpClient);
            HttpClientUtils.closeQuietly(response);
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private ResponseResult execute(HttpRequestBase requestBase) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        CloseableHttpResponse response = null;
        ResponseResult result = null;
        Map<String, Object> errors = null;
        int statusCode = 0;
        try {
            response = httpClient.execute(requestBase);
            String json = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
//			if (log.isDebugEnabled()) {
//////				log.debug("response content:{}", json);
////			}
            statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                errors = objectMapper.readValue(json, Map.class);
                result = new ResponseResult().setResponseBody(errors);
            } else {
                result = objectMapper.readValue(json, ResponseResult.class);
            }
            result.setCode(statusCode + "");
        } catch (Exception ex) {
//			log.error(ex.getMessage(), ex);
        } finally {
            HttpClientUtils.closeQuietly(httpClient);
            HttpClientUtils.closeQuietly(response);
        }
        return result;
    }

}
