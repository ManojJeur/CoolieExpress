package com.coolieexpress.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginRequestDto {
    @NotBlank(message = "Login ID (Email/Phone) is required")
    private String loginId;

    @NotBlank(message = "Password is required")
    private String password;

    public LoginRequestDto() {}

    public String getLoginId() { return loginId; }
    public void setLoginId(String loginId) { this.loginId = loginId; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
