package com.viniciushoffmanndev.agroconnect_api.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private final String SECRET = "vinicius-agroconnect-secret";

    public String gerarToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // expira em 24h
                .signWith(SignatureAlgorithm.HS256, SECRET.getBytes())
                .compact();
    }
}
