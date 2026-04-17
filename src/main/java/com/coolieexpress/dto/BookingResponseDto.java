package com.coolieexpress.dto;

import com.coolieexpress.entity.BookingStatus;
import java.time.LocalDateTime;

public class BookingResponseDto {
    private Long id;
    private UserDto traveler;
    private UserDto coolie;
    private BookingStatus status;
    private LocalDateTime time;
    private Long locationId;

    public BookingResponseDto() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public UserDto getTraveler() { return traveler; }
    public void setTraveler(UserDto traveler) { this.traveler = traveler; }
    public UserDto getCoolie() { return coolie; }
    public void setCoolie(UserDto coolie) { this.coolie = coolie; }
    public BookingStatus getStatus() { return status; }
    public void setStatus(BookingStatus status) { this.status = status; }
    public LocalDateTime getTime() { return time; }
    public void setTime(LocalDateTime time) { this.time = time; }
    public Long getLocationId() { return locationId; }
    public void setLocationId(Long locationId) { this.locationId = locationId; }
}
