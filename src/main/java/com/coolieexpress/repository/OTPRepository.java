package com.coolieexpress.repository;

import com.coolieexpress.entity.OTP;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OTPRepository extends JpaRepository<OTP, Long> {
    Optional<OTP> findTopByUserEmailOrderByExpiryDesc(String email);
    Optional<OTP> findTopByUserPhoneOrderByExpiryDesc(String phone);
}
