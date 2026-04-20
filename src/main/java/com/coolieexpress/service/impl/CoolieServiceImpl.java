package com.coolieexpress.service.impl;

import com.coolieexpress.dto.UserDto;
import com.coolieexpress.dto.UserMapper;
import com.coolieexpress.dto.CoolieResponseDto;
import com.coolieexpress.entity.Status;
import com.coolieexpress.entity.Role;
import com.coolieexpress.entity.User;
import com.coolieexpress.entity.Location;
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
    public List<CoolieResponseDto> getCooliesByLocationAndAvailability(String locationName, Status status) {
        List<User> coolies;
        if (status == null) {
            coolies = userRepository.findByRoleAndCurrentLocation_NameIgnoreCase(Role.COOLIE, locationName);
        } else {
            coolies = userRepository.findByRoleAndCurrentLocation_NameIgnoreCaseAndStatus(Role.COOLIE, locationName, status);
        }
        
        return coolies.stream()
                .map(u -> {
                    CoolieResponseDto dto = new CoolieResponseDto();
                    dto.setId(u.getId());
                    dto.setName(u.getName());
                    dto.setPhone(u.getPhone());
                    dto.setStatus(u.getStatus());
                    if (u.getCurrentLocation() != null) {
                        dto.setLocationName(u.getCurrentLocation().getName());
                    }
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateAvailability(Long coolieId, Status status) {
        User coolie = userRepository.findById(coolieId)
                .orElseThrow(() -> new RuntimeException("Coolie not found"));
                
        if (coolie.getRole() != Role.COOLIE) {
            throw new RuntimeException("User is not a COOLIE");
        }
        
        coolie.setStatus(status);
        userRepository.save(coolie);
        return userMapper.toDto(coolie);
    }
}
