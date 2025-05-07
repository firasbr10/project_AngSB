package com.operation.maintenance.rest;

import com.operation.maintenance.pojo.AuthenticationRequest;
import com.operation.maintenance.pojo.AuthenticationResponse;
import com.operation.maintenance.jwt.JwtUtil; 
import com.operation.maintenance.service.TechnicienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthenticationController {

    @Autowired
    private TechnicienService technicienService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody AuthenticationRequest authenticationRequest) {
        
        if (technicienService.authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword())) {
            String jwt = jwtUtil.generateToken(authenticationRequest.getUsername());
            return new AuthenticationResponse(jwt);
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }
}
