package com.example.demo.util;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author young
 * @date 2022/8/19 21:52
 * @description: 统一返回结果的类
 */
@Data
public class R<T> implements Serializable {

  private static final long serialVersionUID = 56665257248936049L;
  /** 响应码* */
  private Integer code;

  /** 返回消息* */
  private String message;

  /** 返回数据* */
  private T data;

  private R() {}
  /** 操作成功ok方法 */
  public static <T> R<T> ok(T data) {
    R<T> response = new R<>();
    response.setCode(ResponseEnum.SUCCESS.getCode());
    response.setMessage(ResponseEnum.SUCCESS.getResultMessage());
    response.setData(data);
    return response;
  }

  /** 编译失败方法 */
  public static <T> R<T> buildFailure(Integer errCode, String errMessage) {
    R<T> response = new R<>();
    response.setCode(errCode);
    response.setMessage(errMessage);
    return response;
  }

  public static <T> R<T> exception(Integer errCode, String errMessage) {
    R<T> response = new R<>();
    response.setCode(errCode);
    response.setMessage(errMessage);
    return response;
  }
}
