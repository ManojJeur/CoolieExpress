package com.coolieexpress.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    private String station;
    private String city;

    public Location() {}

    public Location(Long id, String name, String station, String city) {
        this.id = id;
        this.name = name;
        this.station = station;
        this.city = city;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getStation() { return station; }
    public void setStation(String station) { this.station = station; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
}
