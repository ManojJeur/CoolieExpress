package com.coolieexpress.service;

import com.coolieexpress.entity.User;

public interface OtpService {
    void generateAndSendOtp(User user);
    boolean verifyOtp(String loginId, String code);
}
