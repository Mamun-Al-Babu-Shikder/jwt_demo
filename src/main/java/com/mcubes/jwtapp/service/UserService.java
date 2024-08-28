package com.mcubes.jwtapp.service;

import com.mcubes.jwtapp.model.AppUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
    private static final List<AppUser> appUsers = new ArrayList<>();

    static {
        // $2a$10$LoCTDlAJwbFHB9kH2tPmYO.g/MvHVGwEZP/2t/4fWxQjORm7aIKzS = 123456
        appUsers.add(new AppUser("user", "$2a$10$LoCTDlAJwbFHB9kH2tPmYO.g/MvHVGwEZP/2t/4fWxQjORm7aIKzS", List.of("ROLE_USER")));
        appUsers.add(new AppUser("admin", "$2a$10$LoCTDlAJwbFHB9kH2tPmYO.g/MvHVGwEZP/2t/4fWxQjORm7aIKzS", List.of("ROLE_ADMIN")));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return appUsers.stream()
                .filter(u -> u.username().equals(username))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("User not found!"));
    }
}
