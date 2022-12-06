package com.javaex.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {

    //토큰 생성
    public static String createToken(String email, String key, long expireTile) {
        Claims claims = Jwts.claims();
        claims.put("email", email);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis())) //지금 시간부터
                .setExpiration(new Date(System.currentTimeMillis() + expireTile)) //언제까지
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();
    }
}
