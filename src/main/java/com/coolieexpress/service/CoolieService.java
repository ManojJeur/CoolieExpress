package com.coolieexpress.service;

import com.coolieexpress.dto.UserDto;
import com.coolieexpress.entity.AvailabilityStatus;
import java.util.List;

public interface CoolieService {
    List<UserDto> getCooliesByLocationAndAvailability(Long locationId, AvailabilityStatus status);
    UserDto updateAvailability(Long coolieId, AvailabilityStatus status);
}
