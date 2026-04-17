package com.coolieexpress.dto;

import jakarta.validation.constraints.NotBlank;

public class OtpVerificationDto {
    @NotBlank(message = "Login ID is required")
    private String loginId;

    @NotBlank(message = "OTP code is required")
    private String code;

    public OtpVerificationDto() {}

    public String getLoginId() { return loginId; }
    public void setLoginId(String loginId) { this.loginId = loginId; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
}
