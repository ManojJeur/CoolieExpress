package com.coolieexpress.dto;

import com.coolieexpress.entity.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AuthRequestDto {
    @NotBlank(message = "Name is required")
    private String name;
    
    @Email(message = "Valid email is required")
    @NotBlank(message = "Email is required")
    private String email;
    
    @NotBlank(message = "Phone is required")
    private String phone;
    
    @NotBlank(message = "Password is required")
    private String password;
    
    @NotNull(message = "Role is required")
    private Role role;
    
    private Double pricePerBag;

    public AuthRequestDto() {}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }
    public Double getPricePerBag() { return pricePerBag; }
    public void setPricePerBag(Double pricePerBag) { this.pricePerBag = pricePerBag; }
}
