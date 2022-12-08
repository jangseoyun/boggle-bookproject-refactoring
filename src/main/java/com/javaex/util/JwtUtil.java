package com.javaex.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {

    private static Claims extractClaims(String token, String key) {//일종의 map 키:밸류로 되어있다
        return Jwts
                .parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody();
    }

    public static String getUserEmail(String token, String key) {
        return extractClaims(token, key).get("email").toString();
    }
    public static boolean isExpired(String token, String secretKey) {
        //expire timestamp를 return 함
        Date expiration = extractClaims(token, secretKey).getExpiration();
        return expiration.before(new Date());
    }

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
