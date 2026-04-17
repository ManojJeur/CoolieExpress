package com.coolieexpress.service;

import com.coolieexpress.dto.AuthRequestDto;
import com.coolieexpress.dto.LoginRequestDto;

public interface AuthService {
    String register(AuthRequestDto authRequestDto);
    String verifyRegistrationOtp(String loginId, String code);
    String login(LoginRequestDto loginRequestDto);
}
