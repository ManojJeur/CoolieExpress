package com.coolieexpress.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "traveler_id", nullable = false)
    private User traveler;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coolie_id", nullable = false)
    private User coolie;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;
    
    private LocalDateTime time;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    public Booking() {}

    public Booking(Long id, User traveler, User coolie, BookingStatus status, LocalDateTime time, Location location) {
        this.id = id;
        this.traveler = traveler;
        this.coolie = coolie;
        this.status = status;
        this.time = time;
        this.location = location;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public User getTraveler() { return traveler; }
    public void setTraveler(User traveler) { this.traveler = traveler; }
    public User getCoolie() { return coolie; }
    public void setCoolie(User coolie) { this.coolie = coolie; }
    public BookingStatus getStatus() { return status; }
    public void setStatus(BookingStatus status) { this.status = status; }
    public LocalDateTime getTime() { return time; }
    public void setTime(LocalDateTime time) { this.time = time; }
    public Location getLocation() { return location; }
    public void setLocation(Location location) { this.location = location; }
}
