package com.coolieexpress.dto;

import com.coolieexpress.entity.Status;

public class CoolieResponseDto {
    private Long id;
    private String name;
    private String phone;
    private Status status;
    private String locationName;

    public CoolieResponseDto() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
    public String getLocationName() { return locationName; }
    public void setLocationName(String locationName) { this.locationName = locationName; }
}
