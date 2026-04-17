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

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class OtpServiceImpl implements OtpService {
    private static final Logger logger = LoggerFactory.getLogger(OtpServiceImpl.class);
    private final OTPRepository otpRepository;
    private final JavaMailSender mailSender;

    public OtpServiceImpl(OTPRepository otpRepository, JavaMailSender mailSender) {
        this.otpRepository = otpRepository;
        this.mailSender = mailSender;
    }

    @Override
    public void generateAndSendOtp(User user) {
        String code = String.format("%04d", new Random().nextInt(10000));
        
        OTP otp = new OTP();
        otp.setCode(code);
        otp.setExpiry(LocalDateTime.now().plusMinutes(10));
        otp.setUser(user);
        
        otpRepository.save(otp);
        
        // Send email
        if (user.getEmail() != null && !user.getEmail().isEmpty()) {
            try {
                SimpleMailMessage message = new SimpleMailMessage();
                message.setFrom("manojjeurspring@gmail.com");
                message.setTo(user.getEmail());
                message.setSubject("Coolie Express - Verification Code");
                message.setText("Your Coolie Express verification code is: " + code + "\n\nThis code will expire in 10 minutes.");
                
                mailSender.send(message);
                logger.info("OTP email sent successfully to: " + user.getEmail());
            } catch (Exception e) {
                logger.error("Failed to send OTP email to: " + user.getEmail(), e);
            }
        } else {
            // Log if we still need to send SMS or handle no email
            logger.info("MOCK SMS SENDER to " + user.getPhone() + " : Your Coolie Express verification code is: " + code);
        }
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
