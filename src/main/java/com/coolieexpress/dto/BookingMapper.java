package com.coolieexpress.dto;

import com.coolieexpress.entity.Booking;
import org.springframework.stereotype.Component;

@Component
public class BookingMapper {
    private final UserMapper userMapper;

    public BookingMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public BookingResponseDto toDto(Booking booking) {
        if (booking == null) {
            return null;
        }
        BookingResponseDto dto = new BookingResponseDto();
        dto.setId(booking.getId());
        dto.setTraveler(userMapper.toDto(booking.getTraveler()));
        dto.setCoolie(userMapper.toDto(booking.getCoolie()));
        dto.setStatus(booking.getStatus());
        dto.setTime(booking.getTime());
        if (booking.getLocation() != null) {
            dto.setLocationId(booking.getLocation().getId());
        }
        return dto;
    }
}
