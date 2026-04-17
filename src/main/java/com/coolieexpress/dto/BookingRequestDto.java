package com.coolieexpress.dto;

import jakarta.validation.constraints.NotNull;

public class BookingRequestDto {
    @NotNull(message = "Coolie ID is required")
    private Long coolieId;

    @NotNull(message = "Location ID is required")
    private Long locationId;

    public BookingRequestDto() {}

    public Long getCoolieId() { return coolieId; }
    public void setCoolieId(Long coolieId) { this.coolieId = coolieId; }
    public Long getLocationId() { return locationId; }
    public void setLocationId(Long locationId) { this.locationId = locationId; }
}
