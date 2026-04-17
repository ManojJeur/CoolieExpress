package com.coolieexpress.dto;

import com.coolieexpress.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto toDto(User user) {
        if (user == null) {
            return null;
        }
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPhone(user.getPhone());
        dto.setRole(user.getRole());
        dto.setAvailabilityStatus(user.getAvailabilityStatus());
        dto.setPricePerBag(user.getPricePerBag());
        if (user.getCurrentLocation() != null) {
            dto.setCurrentLocationId(user.getCurrentLocation().getId());
        }
        return dto;
    }
}
