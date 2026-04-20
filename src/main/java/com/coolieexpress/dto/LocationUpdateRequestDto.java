package com.coolieexpress.dto;

import jakarta.validation.constraints.NotBlank;

public class LocationUpdateRequestDto {
    
    @NotBlank(message = "Location Name is required")
    private String locationName;

    public LocationUpdateRequestDto() {}

    public String getLocationName() { return locationName; }
    public void setLocationName(String locationName) { this.locationName = locationName; }
}
