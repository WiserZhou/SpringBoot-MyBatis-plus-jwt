package com.example.demo.config;

import com.example.demo.filter.MyJwtInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author young
 * @date 2022/9/12 15:36
 * @description: JWT拦截配置
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry
        .addInterceptor(jwtInterceptor())
        // 拦截所有请求，通过判断token来决定是否需要登陆
        .addPathPatterns("/**");
  }

  @Bean
  public MyJwtInterceptor jwtInterceptor() {
    return new MyJwtInterceptor();
  }
}
