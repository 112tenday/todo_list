package com.test.todo_list.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        // Logika login di sini, misalnya verifikasi username dan password
        return ResponseEntity.ok("Login Successful");
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest) {
        // Logika registrasi di sini, misalnya menyimpan pengguna baru
        return ResponseEntity.ok("Registration Successful");
    }
}

class LoginRequest {
    private String username;
    private String password;

    // Getters and Setters
}

class RegisterRequest {
    private String username;
    private String email;
    private String password;

    // Getters and Setters
}


