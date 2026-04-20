package com.coolieexpress.service;

import com.coolieexpress.dto.UserDto;
import com.coolieexpress.entity.Role;
import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
    UserDto getUserById(Long id);
    void deleteUser(Long id);
    UserDto updateRole(Long id, Role role);
    UserDto updateUserLocation(Long id, String locationName);
}
