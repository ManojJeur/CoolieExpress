package com.coolieexpress.controller;

import com.coolieexpress.dto.AuthRequestDto;
import com.coolieexpress.dto.LoginRequestDto;
import com.coolieexpress.dto.OtpVerificationDto;
import com.coolieexpress.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody AuthRequestDto dto) {
        return ResponseEntity.ok(authService.register(dto));
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<String> verifyOtp(@Valid @RequestBody OtpVerificationDto dto) {
        return ResponseEntity.ok(authService.verifyRegistrationOtp(dto.getLoginId(), dto.getCode()));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginRequestDto dto) {
        String token = authService.login(dto);
        return ResponseEntity.ok(token);
    }
}
