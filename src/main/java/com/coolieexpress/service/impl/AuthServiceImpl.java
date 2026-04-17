package com.coolieexpress.service.impl;

import com.coolieexpress.dto.AuthRequestDto;
import com.coolieexpress.dto.LoginRequestDto;
import com.coolieexpress.entity.User;
import com.coolieexpress.repository.UserRepository;
import com.coolieexpress.security.CustomUserDetails;
import com.coolieexpress.security.JwtUtil;
import com.coolieexpress.service.AuthService;
import com.coolieexpress.service.OtpService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final OtpService otpService;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder,
                           AuthenticationManager authenticationManager, JwtUtil jwtUtil, OtpService otpService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.otpService = otpService;
    }

    @Override
    public String register(AuthRequestDto authRequestDto) {
        if (userRepository.findByEmail(authRequestDto.getEmail()).isPresent()) {
            throw new RuntimeException("Email is already registered");
        }
        if (userRepository.findByPhone(authRequestDto.getPhone()).isPresent()) {
            throw new RuntimeException("Phone is already registered");
        }

        User user = new User();
        user.setName(authRequestDto.getName());
        user.setEmail(authRequestDto.getEmail());
        user.setPhone(authRequestDto.getPhone());
        user.setPassword(passwordEncoder.encode(authRequestDto.getPassword()));
        user.setRole(authRequestDto.getRole());
        if (com.coolieexpress.entity.Role.COOLIE.equals(authRequestDto.getRole())) {
            user.setPricePerBag(authRequestDto.getPricePerBag());
        }
        
        userRepository.save(user);
        otpService.generateAndSendOtp(user);
        
        return "Registration successful. OTP sent for verification.";
    }

    @Override
    public String verifyRegistrationOtp(String loginId, String code) {
        boolean isValid = otpService.verifyOtp(loginId, code);
        if (!isValid) {
            throw new RuntimeException("Invalid or expired OTP");
        }
        return "OTP verified successfully. You can now login.";
    }

    @Override
    public String login(LoginRequestDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getLoginId(), loginDto.getPassword())
        );
        
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        return jwtUtil.generateToken(userDetails);
    }
}
