package com.coolieexpress.dto;

import com.coolieexpress.entity.Status;
import com.coolieexpress.entity.Role;

public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private Role role;
    private Status status;
    private Double pricePerBag;
    private Long currentLocationId;

    public UserDto() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
    public Double getPricePerBag() { return pricePerBag; }
    public void setPricePerBag(Double pricePerBag) { this.pricePerBag = pricePerBag; }
    public Long getCurrentLocationId() { return currentLocationId; }
    public void setCurrentLocationId(Long currentLocationId) { this.currentLocationId = currentLocationId; }
}
