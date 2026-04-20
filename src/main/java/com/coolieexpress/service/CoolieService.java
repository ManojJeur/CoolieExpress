package com.coolieexpress.service;

import com.coolieexpress.dto.UserDto;
import com.coolieexpress.dto.CoolieResponseDto;
import com.coolieexpress.entity.Status;
import java.util.List;

public interface CoolieService {
    List<CoolieResponseDto> getCooliesByLocationAndAvailability(String locationName, Status status);
    UserDto updateAvailability(Long coolieId, Status status);
}
