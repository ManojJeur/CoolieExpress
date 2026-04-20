package com.coolieexpress.controller;

import com.coolieexpress.dto.LocationUpdateRequestDto;
import com.coolieexpress.dto.UserDto;
import com.coolieexpress.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/travelers")
@SecurityRequirement(name = "bearerAuth")
public class TravelerController {

    private final UserService userService;

    public TravelerController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/{id}/location")
    @PreAuthorize("hasRole('TRAVELER')")
    public ResponseEntity<UserDto> updateLocation(@PathVariable Long id, @Valid @RequestBody LocationUpdateRequestDto request) {
        return ResponseEntity.ok(userService.updateUserLocation(id, request.getLocationName()));
    }
}
