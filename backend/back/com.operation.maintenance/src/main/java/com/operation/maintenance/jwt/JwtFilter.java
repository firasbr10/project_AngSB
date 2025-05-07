package com.operation.maintenance.jwt; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    // Filtrage de la requête pour vérifier le token
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");

        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7); // Extraire le token

            String username = jwtUtil.extractUsername(token); // Extraire le nom d'utilisateur du token

            if (username != null && jwtUtil.validateToken(token, username)) {
                // Authentification réussie, continuer la chaîne de filtres
                request.setAttribute("username", username);
            }
        }

        // Continuer le traitement de la requête
        filterChain.doFilter(request, response);
    }
}
