package com.coolieexpress.service.impl;

import com.coolieexpress.dto.UserDto;
import com.coolieexpress.dto.UserMapper;
import com.coolieexpress.entity.AvailabilityStatus;
import com.coolieexpress.entity.Role;
import com.coolieexpress.entity.User;
import com.coolieexpress.repository.UserRepository;
import com.coolieexpress.service.CoolieService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoolieServiceImpl implements CoolieService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public CoolieServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDto> getCooliesByLocationAndAvailability(Long locationId, AvailabilityStatus status) {
        List<User> coolies = userRepository.findByRole(Role.COOLIE);
        
        return coolies.stream()
                .filter(u -> locationId == null || (u.getCurrentLocation() != null && u.getCurrentLocation().getId().equals(locationId)))
                .filter(u -> status == null || u.getAvailabilityStatus() == status)
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateAvailability(Long coolieId, AvailabilityStatus status) {
        User coolie = userRepository.findById(coolieId)
                .orElseThrow(() -> new RuntimeException("Coolie not found"));
                
        if (coolie.getRole() != Role.COOLIE) {
            throw new RuntimeException("User is not a COOLIE");
        }
        
        coolie.setAvailabilityStatus(status);
        userRepository.save(coolie);
        return userMapper.toDto(coolie);
    }
}
