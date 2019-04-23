package com.quiz.commons.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO : 다시 공부 후 적용하기
 * 인증 방식을 token 으로 처리해볼려고 했으나, 기초 지식이 너무나 부족하여 잠시 중단
 * 다시 공부 후 만들어야겠다.
 */

@Component
public class JwtCreator {
    private static final Logger log = LoggerFactory.getLogger(JwtCreator.class);

    private static final String SALT =  "quiz_scret";

    private static final long DEFAULT_EXPIRED_TIME = 50000L;

    public <T> String create(String key, T data, String subject) {
        Map<String, Object> headerMap = new HashMap<>();
        headerMap.put("typ","JWT");
        headerMap.put("alg","HS256");
        headerMap.put("regDate", System.currentTimeMillis());

        return Jwts
                .builder()
                .setHeader(headerMap)
                .setExpiration(DateUtils.convertToDate(DateUtils.after(DEFAULT_EXPIRED_TIME)))
                .claim(key, data)
                .signWith(SignatureAlgorithm.ES256, this.generateKey())
                .compact();
    }

    private byte[] generateKey(){
        byte[] key = null;
        try {
            key = SALT.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            if(log.isInfoEnabled()){
                e.printStackTrace();
            }else{
                log.error("Making JWT Key Error ::: {}", e.getMessage());
            }
        }

        return key;
    }
}
