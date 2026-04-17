package com.coolieexpress.repository;

import com.coolieexpress.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByTravelerId(Long travelerId);
    List<Booking> findByCoolieId(Long coolieId);
}
