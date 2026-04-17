package com.coolieexpress.service.impl;

import com.coolieexpress.entity.OTP;
import com.coolieexpress.entity.User;
import com.coolieexpress.repository.OTPRepository;
import com.coolieexpress.service.OtpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class OtpServiceImpl implements OtpService {
    private static final Logger logger = LoggerFactory.getLogger(OtpServiceImpl.class);
    private final OTPRepository otpRepository;

    public OtpServiceImpl(OTPRepository otpRepository) {
        this.otpRepository = otpRepository;
    }

    @Override
    public void generateAndSendOtp(User user) {
        String code = String.format("%04d", new Random().nextInt(10000));
        
        OTP otp = new OTP();
        otp.setCode(code);
        otp.setExpiry(LocalDateTime.now().plusMinutes(10));
        otp.setUser(user);
        
        otpRepository.save(otp);
        
        // Simulate email/SMS
        logger.info("\n========================================\n" +
                    "MOCK EMAIL/SMS SENDER\n" +
                    "To: " + user.getEmail() + " / " + user.getPhone() + "\n" +
                    "Your Coolie Express verification code is: " + code + "\n" +
                    "========================================");
    }

    @Override
    public boolean verifyOtp(String loginId, String code) {
        Optional<OTP> otpOptional = otpRepository.findTopByUserEmailOrderByExpiryDesc(loginId);
        if (otpOptional.isEmpty()) {
            otpOptional = otpRepository.findTopByUserPhoneOrderByExpiryDesc(loginId);
        }
        
        if (otpOptional.isPresent()) {
            OTP otp = otpOptional.get();
            if (otp.getCode().equals(code) && otp.getExpiry().isAfter(LocalDateTime.now())) {
                return true;
            }
        }
        return false;
    }
}
