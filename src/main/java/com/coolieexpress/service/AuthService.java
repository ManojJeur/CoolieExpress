package com.coolieexpress.service;

import com.coolieexpress.dto.AuthRequestDto;
import com.coolieexpress.dto.LoginRequestDto;

import com.coolieexpress.dto.LoginResponseDto;

public interface AuthService {
    String register(AuthRequestDto authRequestDto);
    String verifyRegistrationOtp(String loginId, String code);
    LoginResponseDto login(LoginRequestDto loginRequestDto);
}
