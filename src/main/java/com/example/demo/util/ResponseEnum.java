package com.example.demo.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import java.util.UUID;

/**
 * @author young
 * @date 2022/8/19 21:36
 * @description: 响应结果枚举
 */
@AllArgsConstructor
@Getter
public enum ResponseEnum {
  /** 响应成功* */
  SUCCESS(200, "操作成功"),
  /** 操作失败 */
  FAIL(201, "获取数据失败"),

  NO_TOKEN(400, "无token，请重新登录"),
  TOKEN_EX(401, "token验证失败，请重新登录"),

  USER_EX(402, "用户不存在，请重新登录"),

  /** 错误请求* */
  ERROR(400, "错误请求");

  /** 响应码* */
  private final Integer code;

  /** 结果 * */
  private final String resultMessage;

  /**
   * @param code
   * @return 返回code对应的枚举元素，包括code和message
   */
  public static ResponseEnum getResultCode(Integer code) {
    for (ResponseEnum value : ResponseEnum.values()) {
      if (code.equals(value.getCode())) {
        return value;
      }
    }
    return ResponseEnum.ERROR;
  }

}
