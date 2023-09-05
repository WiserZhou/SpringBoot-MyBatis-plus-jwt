package com.example.demo.util;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/**
 * @author young
 * @date 2022/9/12 15:43
 * @description: 自定义异常配置
 */
@RestControllerAdvice
public class GlobalExceptionConfig {
  @ExceptionHandler(MyException.class)
  public R<MyException> handle(MyException e) {
    e.printStackTrace();
    return R.exception(e.getCode(), e.getMessage());
  }
}
