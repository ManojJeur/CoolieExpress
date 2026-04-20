package com.coolieexpress.controller;

import com.coolieexpress.dto.CoolieResponseDto;
import com.coolieexpress.dto.UserDto;
import com.coolieexpress.dto.LocationUpdateRequestDto;
import com.coolieexpress.entity.Status;
import com.coolieexpress.service.CoolieService;
import com.coolieexpress.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coolies")
@SecurityRequirement(name = "bearerAuth")
public class CoolieController {

    private final CoolieService coolieService;
    private final UserService userService;

    public CoolieController(CoolieService coolieService, UserService userService) {
        this.coolieService = coolieService;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<CoolieResponseDto>> getCoolies(
            @RequestParam String locationName,
            @RequestParam(required = false) Status status) {
        return ResponseEntity.ok(coolieService.getCooliesByLocationAndAvailability(locationName, status));
    }

    @PutMapping("/{id}/availability")
    @PreAuthorize("hasRole('COOLIE')")
    public ResponseEntity<UserDto> updateAvailability(@PathVariable Long id, @RequestParam Status status) {
        return ResponseEntity.ok(coolieService.updateAvailability(id, status));
    }

    @PutMapping("/{id}/location")
    @PreAuthorize("hasRole('COOLIE')")
    public ResponseEntity<UserDto> updateLocation(@PathVariable Long id, @Valid @RequestBody LocationUpdateRequestDto request) {
        return ResponseEntity.ok(userService.updateUserLocation(id, request.getLocationName()));
    }
}
