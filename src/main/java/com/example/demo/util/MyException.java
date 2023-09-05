package com.example.demo.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author young
 * @date 2022/9/25 19:15
 * @description: 自定义运行时异常
 */
@Data
@ApiModel(value = "自定义全局异常类")
public class MyException extends RuntimeException {

  @ApiModelProperty(value = "异常状态码")
  private final Integer code;

  /**
   * 通过状态码和异常信息创建异常对象
   *
   * @param code
   * @param message
   */
  public MyException(Integer code, String message) {
    super(message);
    this.code = code;
  }

  public MyException(ResponseEnum responseEnum) {
    super(responseEnum.getResultMessage());
    this.code = responseEnum.getCode();
  }
}
