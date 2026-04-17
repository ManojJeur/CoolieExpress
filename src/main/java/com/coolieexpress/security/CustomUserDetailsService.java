package com.coolieexpress.security;

import com.coolieexpress.entity.User;
import com.coolieexpress.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Authenticate via Email or Phone natively.
        Optional<User> userOptional = userRepository.findByEmail(username);
        if (userOptional.isEmpty()) {
            userOptional = userRepository.findByPhone(username);
        }
        
        User user = userOptional.orElseThrow(() -> new UsernameNotFoundException("User not found with login identifier: " + username));
        
        return new CustomUserDetails(user);
    }
}
