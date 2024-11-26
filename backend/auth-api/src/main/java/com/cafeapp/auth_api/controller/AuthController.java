package com.cafeapp.auth_api.controller;

import com.cafeapp.auth_api.dto.UserLoginDTO;
import com.cafeapp.auth_api.dto.UserRegisterDTO;
import com.cafeapp.auth_api.entity.UserEntity;
import com.cafeapp.auth_api.service.UserService;
import com.cafeapp.auth_api.util.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")

public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody @Valid UserRegisterDTO dto) {
        userService.register(dto);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Usuário registrado com sucesso.");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody @Valid UserLoginDTO dto) {
        UserEntity user = userService.authenticate(dto);
        String token = jwtUtil.generateToken(new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(), new ArrayList<>()));

        // Encapsula o token em um objeto JSON
        Map<String, String> response = new HashMap<>();
        response.put("token", token);

        return ResponseEntity.ok(response);
    }
}