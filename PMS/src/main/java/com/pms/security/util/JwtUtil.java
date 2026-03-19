/**
 * 
 */
package com.pms.security.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.pms.security.service.CustomUserDetailsService;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
	
	static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);
	
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private final long expirationMs = 3600000; // 1 hour
    
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
                .signWith(key)
                .compact();
    }

    public String validateToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}


