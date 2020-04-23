package cn.ali.outpatient.controller;

import cn.ali.common.http.HttpClientHelper;
import cn.ali.common.response.ResponseEnum;
import cn.ali.common.response.ResponseResult;
import cn.ali.outpatient.pojo.RecipeTemplate;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.language.Nysiis;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

@Api
@RestController
@RequestMapping("/api/outpatient/drug")
public class DrugController {
    @Resource
    private HttpClientHelper httpClientHelper;

    private final String CURRENT_SERVER_URL="http://localhost:8081";

    @ApiOperation(value = "药品信息查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "recipeType",value ="处方类型" ),
            @ApiImplicitParam(name = "drug_typeId",value ="药品类型" ),
            @ApiImplicitParam(name = "drugNameOrPinYinCode",value ="药品或拼音编码" )
    })
    @GetMapping("/list")
    public ResponseResult list(HttpServletRequest request,Integer recipeType, Integer drug_typeId, String drugNameOrPinYinCode ) throws IOException {
        Map<String, Object> params = new HashMap<>();
        if (recipeType !=null){
            params.put("recipeType", recipeType);
        }else if (drug_typeId !=null){
            params.put("drug_typeId", drug_typeId);
        }else if (drugNameOrPinYinCode !=null){
            params.put("drugNameOrPinYinCode", drugNameOrPinYinCode);
        }
        ResponseResult result = httpClientHelper.getForResponse(CURRENT_SERVER_URL+"/api/drug/list",params);

        return result;
    }




}
