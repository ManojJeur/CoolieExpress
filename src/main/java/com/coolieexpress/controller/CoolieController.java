package com.coolieexpress.controller;

import com.coolieexpress.dto.UserDto;
import com.coolieexpress.entity.AvailabilityStatus;
import com.coolieexpress.service.CoolieService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coolies")
@SecurityRequirement(name = "bearerAuth")
public class CoolieController {

    private final CoolieService coolieService;

    public CoolieController(CoolieService coolieService) {
        this.coolieService = coolieService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getCoolies(
            @RequestParam(required = false) Long locationId,
            @RequestParam(required = false) AvailabilityStatus status) {
        return ResponseEntity.ok(coolieService.getCooliesByLocationAndAvailability(locationId, status));
    }

    @PutMapping("/{id}/availability")
    @PreAuthorize("hasRole('COOLIE')")
    public ResponseEntity<UserDto> updateAvailability(@PathVariable Long id, @RequestParam AvailabilityStatus status) {
        return ResponseEntity.ok(coolieService.updateAvailability(id, status));
    }
}
