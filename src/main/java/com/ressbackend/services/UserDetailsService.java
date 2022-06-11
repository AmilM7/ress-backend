package com.ressbackend.services;

import com.ressbackend.models.SimpleUser;
import com.ressbackend.models.Users;
import com.ressbackend.repositories.AdminRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    private final AdminRepository adminRepository;

    public UserDetailsService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Users user = getFullUserByEmail(userName);

        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(), Collections.emptyList());
    }

    public SimpleUser getUserByEmail(String userEmail) {
        getFullUserByEmail(userEmail);
        return new SimpleUser(userEmail);
    }

    private Users getFullUserByEmail(String email) {
        return adminRepository.findFirstByEmail(email);
    }
}
