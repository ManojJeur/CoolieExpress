package com.coolieexpress.service;

import com.coolieexpress.dto.BookingRequestDto;
import com.coolieexpress.dto.BookingResponseDto;
import com.coolieexpress.entity.BookingStatus;
import java.util.List;

public interface BookingService {
    BookingResponseDto createBooking(Long travelerId, BookingRequestDto dto);
    BookingResponseDto updateBookingStatus(Long bookingId, Long coolieId, BookingStatus status);
    List<BookingResponseDto> getBookingsByTraveler(Long travelerId);
    List<BookingResponseDto> getBookingsByCoolie(Long coolieId);
}
