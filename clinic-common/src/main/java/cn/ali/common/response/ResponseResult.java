package cn.ali.common.response;

import lombok.Data;

/**
 * 接口响应
 *
 */
@Data
public class ResponseResult {

  private String code;

  private String message;

  private long responseTime = System.currentTimeMillis();

  private Object responseBody;
  
  public ResponseResult() {
  }
  
  public ResponseResult(ResponseEnum responseEnum) {
    this.code = responseEnum.getCode();
    this.message = responseEnum.getMessage();
  }

  public ResponseResult setResponseBody(Object responseBody) {
    this.responseBody = responseBody;
    return this;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public long getResponseTime() {
    return responseTime;
  }

  public void setResponseTime(long responseTime) {
    this.responseTime = responseTime;
  }

  public Object getResponseBody() {
    return responseBody;
  }
}
