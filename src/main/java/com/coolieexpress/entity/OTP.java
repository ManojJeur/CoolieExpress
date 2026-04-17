package com.coolieexpress.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "otps")
public class OTP {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String code;
    
    @Column(nullable = false)
    private LocalDateTime expiry;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    public OTP() {}
    
    public OTP(Long id, String code, LocalDateTime expiry, User user) {
        this.id = id;
        this.code = code;
        this.expiry = expiry;
        this.user = user;
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public LocalDateTime getExpiry() { return expiry; }
    public void setExpiry(LocalDateTime expiry) { this.expiry = expiry; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
