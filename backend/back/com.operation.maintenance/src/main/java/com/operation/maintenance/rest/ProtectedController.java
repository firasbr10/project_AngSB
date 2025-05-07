package com.operation.maintenance.rest;

import com.operation.maintenance.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/protected")
public class ProtectedController {

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/data")
    public String getData(@RequestHeader("Authorization") String authorizationHeader) {
        String token = authorizationHeader.substring(7); 

        String username = jwtUtil.extractUsername(token); 

        if (jwtUtil.validateToken(token, username)) { 
            return "Accès autorisé aux données sécurisées pour l'utilisateur : " + username;
        } else {
            throw new RuntimeException("Token invalide ou expiré");
        }
    }
}
