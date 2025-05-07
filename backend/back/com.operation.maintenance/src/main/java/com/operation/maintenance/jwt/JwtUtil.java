package com.operation.maintenance.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "maSuperCleSecreteUltraLongueEtComplexe1234567890"; 
    private final SecretKey secretKey = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    // Générer un JWT
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 heure
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    // Extraire le nom d'utilisateur
    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    // Extraire les claims
    private Claims extractClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // Vérifier l'expiration
    public boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }

    // Valider un token
    public boolean validateToken(String token, String username) {
        return (username.equals(extractUsername(token)) && !isTokenExpired(token));
    }
}
