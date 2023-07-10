package com.gosoft.assessmentapi.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;

@Component
public class JwtService {
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

    @Value("${auth.jwt.secret}")
    private String secret;

    public String generateToken(String plainText) {
        return Jwts.builder()
                .setClaims(new HashMap<>())
                .setSubject(plainText)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512, getSigningKey())
                .compact();
    }

    public Claims extractClaims(String token) {
        var claims = Jwts
                .parser()
                .setSigningKey(getSigningKey())
                .parseClaimsJws(token)
                .getBody();
        return claims;
    }

    private String getSigningKey() {
        return secret;
    }
}
