package com.example.demo.util;

import cn.hutool.core.date.DateUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import java.util.Date;
/**
 * @author young
 * @date 2022/9/12 14:46
 * @description: 整合JWT生成token
 */
public class JwtTokenUtils {
    private JwtTokenUtils() {
        throw new IllegalStateException("Utility class");
    }
    /**
     * 生成token
     * @param userId
     * @param sign
     * @return
     */
    public static String getToken(String userId,String sign){
        return  JWT.create()
                //签收者
                .withAudience(userId)
                //主题
                .withSubject("token")
                //2小时候token过期
                .withExpiresAt(DateUtil.offsetHour(new Date(),2))
                //以password作为token的密钥
                .sign(Algorithm.HMAC256(sign));
    }
}