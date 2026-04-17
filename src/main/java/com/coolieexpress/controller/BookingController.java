package com.coolieexpress.controller;

import com.coolieexpress.dto.BookingRequestDto;
import com.coolieexpress.dto.BookingResponseDto;
import com.coolieexpress.entity.BookingStatus;
import com.coolieexpress.service.BookingService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@SecurityRequirement(name = "bearerAuth")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/traveler/{travelerId}")
    @PreAuthorize("hasRole('TRAVELER')")
    public ResponseEntity<BookingResponseDto> createBooking(
            @PathVariable Long travelerId,
            @Valid @RequestBody BookingRequestDto dto) {
        return ResponseEntity.ok(bookingService.createBooking(travelerId, dto));
    }

    @PutMapping("/{bookingId}/status/coolie/{coolieId}")
    @PreAuthorize("hasRole('COOLIE')")
    public ResponseEntity<BookingResponseDto> updateBookingStatus(
            @PathVariable Long bookingId,
            @PathVariable Long coolieId,
            @RequestParam BookingStatus status) {
        return ResponseEntity.ok(bookingService.updateBookingStatus(bookingId, coolieId, status));
    }

    @GetMapping("/traveler/{travelerId}")
    public ResponseEntity<List<BookingResponseDto>> getTravelerBookings(@PathVariable Long travelerId) {
        return ResponseEntity.ok(bookingService.getBookingsByTraveler(travelerId));
    }

    @GetMapping("/coolie/{coolieId}")
    public ResponseEntity<List<BookingResponseDto>> getCoolieBookings(@PathVariable Long coolieId) {
        return ResponseEntity.ok(bookingService.getBookingsByCoolie(coolieId));
    }
}
