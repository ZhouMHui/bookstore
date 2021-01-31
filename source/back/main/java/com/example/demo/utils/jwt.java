package com.example.demo.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import javax.swing.*;
import java.util.Calendar;
import java.util.Map;

public class jwt {

    private static final String SING="easonchou";
    //   生成token  header.payload.sing
    public  static  String getToken(Map<String,String> map)
    {
        Calendar instance =Calendar.getInstance();
        instance.add(Calendar.DATE,1);
        JWTCreator.Builder builder= JWT.create();//创建jwt builder
        map.forEach((k,v)->
        {
            builder.withClaim(k,v);
        });
        String token =builder.withExpiresAt(instance.getTime())//指定过期时间
                .sign(Algorithm.HMAC256(SING));
        return token;
    }

    public static DecodedJWT verify(String token){
        return  JWT.require(Algorithm.HMAC256(SING)).build().verify(token);

    }
}