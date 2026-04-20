package com.coolieexpress.service.impl;

import com.coolieexpress.dto.BookingRequestDto;
import com.coolieexpress.dto.BookingResponseDto;
import com.coolieexpress.dto.BookingMapper;
import com.coolieexpress.entity.*;
import com.coolieexpress.repository.BookingRepository;
import com.coolieexpress.repository.LocationRepository;
import com.coolieexpress.repository.UserRepository;
import com.coolieexpress.service.BookingService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final LocationRepository locationRepository;
    private final BookingMapper bookingMapper;

    public BookingServiceImpl(BookingRepository bookingRepository, UserRepository userRepository,
                              LocationRepository locationRepository, BookingMapper bookingMapper) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.locationRepository = locationRepository;
        this.bookingMapper = bookingMapper;
    }

    @Override
    public BookingResponseDto createBooking(Long travelerId, BookingRequestDto dto) {
        User traveler = userRepository.findById(travelerId)
                .orElseThrow(() -> new RuntimeException("Traveler not found"));
        User coolie = userRepository.findById(dto.getCoolieId())
                .orElseThrow(() -> new RuntimeException("Coolie not found"));
        Location location = locationRepository.findById(dto.getLocationId())
                .orElseThrow(() -> new RuntimeException("Location not found"));

        if (traveler.getRole() != Role.TRAVELER) {
            throw new RuntimeException("Only travelers can create bookings");
        }
        if (coolie.getRole() != Role.COOLIE) {
            throw new RuntimeException("Target user is not a COOLIE");
        }
        if (coolie.getStatus() != Status.AVAILABLE) {
            throw new RuntimeException("Coolie is not currently available");
        }

        Booking booking = new Booking();
        booking.setTraveler(traveler);
        booking.setCoolie(coolie);
        booking.setLocation(location);
        booking.setStatus(BookingStatus.PENDING);
        booking.setTime(LocalDateTime.now());
        
        bookingRepository.save(booking);
        return bookingMapper.toDto(booking);
    }

    @Override
    public BookingResponseDto updateBookingStatus(Long bookingId, Long coolieId, BookingStatus status) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        
        if (!booking.getCoolie().getId().equals(coolieId)) {
            throw new RuntimeException("Not authorized to update this booking");
        }
        
        booking.setStatus(status);
        bookingRepository.save(booking);
        return bookingMapper.toDto(booking);
    }

    @Override
    public List<BookingResponseDto> getBookingsByTraveler(Long travelerId) {
        return bookingRepository.findByTravelerId(travelerId)
                .stream().map(bookingMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<BookingResponseDto> getBookingsByCoolie(Long coolieId) {
        return bookingRepository.findByCoolieId(coolieId)
                .stream().map(bookingMapper::toDto).collect(Collectors.toList());
    }
}
