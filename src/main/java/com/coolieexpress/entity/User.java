package com.coolieexpress.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    @Column(unique = true, nullable = false)
    private String email;
    
    @Column(unique = true, nullable = false)
    private String phone;
    
    private String password;
    
    @Enumerated(EnumType.STRING)
    private Role role;
    
    @Enumerated(EnumType.STRING)
    private AvailabilityStatus availabilityStatus;
    
    private Double pricePerBag;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location currentLocation;

    public User() {}
    
    public User(Long id, String name, String email, String phone, String password, Role role, AvailabilityStatus availabilityStatus, Double pricePerBag, Location currentLocation) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.role = role;
        this.availabilityStatus = availabilityStatus;
        this.pricePerBag = pricePerBag;
        this.currentLocation = currentLocation;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }
    public AvailabilityStatus getAvailabilityStatus() { return availabilityStatus; }
    public void setAvailabilityStatus(AvailabilityStatus availabilityStatus) { this.availabilityStatus = availabilityStatus; }
    public Double getPricePerBag() { return pricePerBag; }
    public void setPricePerBag(Double pricePerBag) { this.pricePerBag = pricePerBag; }
    public Location getCurrentLocation() { return currentLocation; }
    public void setCurrentLocation(Location currentLocation) { this.currentLocation = currentLocation; }
}
