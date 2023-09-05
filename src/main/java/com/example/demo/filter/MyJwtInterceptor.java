package com.example.demo.filter;

import cn.hutool.core.text.CharSequenceUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import com.example.demo.util.MyException;
import com.example.demo.util.PassToken;
import com.example.demo.util.ResponseEnum;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import java.lang.reflect.Method;

/**
 * @author young
 * @date 2022/9/12 15:37
 * @description: 获取token并验证
 */
@Component
public class MyJwtInterceptor implements HandlerInterceptor {
  @Autowired private StudentService studentService;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {

    String token = request.getHeader("token");
    if (!(handler instanceof HandlerMethod)) {
      return true;
    }
    HandlerMethod handlerMethod = (HandlerMethod) handler;
    Method method = handlerMethod.getMethod();
    // 检查是否通过有PassToken注解
    if (method.isAnnotationPresent(PassToken.class)) {
      // 如果有则跳过认证检查
      PassToken passToken = method.getAnnotation(PassToken.class);
      if (passToken.required()) {
        return true;
      }
    }
    // 否则进行token检查
    if (CharSequenceUtil.isBlank(token)) {
      throw new MyException(
          ResponseEnum.TOKEN_EX.getCode(), ResponseEnum.TOKEN_EX.getResultMessage());
    }
    // 获取token中的用户id
    String userId;
    try {
      userId = JWT.decode(token).getAudience().get(0);
    } catch (JWTDecodeException j) {
      throw new MyException(
          ResponseEnum.TOKEN_EX.getCode(), ResponseEnum.TOKEN_EX.getResultMessage());
    }
    // 根据token中的userId查询数据库

    Student student = studentService.getById(userId);
    if (student == null) {
      throw new MyException(
          ResponseEnum.USER_EX.getCode(), ResponseEnum.USER_EX.getResultMessage());
    }

    // 验证token
    JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(student.getPassword())).build();
    try {
      jwtVerifier.verify(token);
    } catch (JWTVerificationException e) {
      throw new MyException(406, "权限验证失败！");
    }
    return true;
  }
}
