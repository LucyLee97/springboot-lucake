package com.example.lucake.controller;

import com.example.lucake.dto.AuthenticationRq;
import com.example.lucake.dto.AuthenticationRs;
import com.example.lucake.dto.RegisterRq;
import com.example.lucake.service.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Auth")
@RequestMapping("/api/auth")
@RestController
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationRs> register(@RequestBody RegisterRq registerRq) {
        return ResponseEntity.ok(authService.register(registerRq));
    }

    @PostMapping
    public ResponseEntity<AuthenticationRs> authentication(@RequestBody AuthenticationRq authenticationRq) {
        return ResponseEntity.ok(authService.authentication(authenticationRq));
    }
}
