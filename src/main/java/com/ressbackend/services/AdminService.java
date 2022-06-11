package com.ressbackend.services;

import com.ressbackend.models.Users;
import com.ressbackend.repositories.AdminRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminService(AdminRepository adminRepository, PasswordEncoder passwordEncoder) {

        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Users> getUsers() {
        return adminRepository.findAll();
    }

    public Users getById(long id) {
        Optional<Users> adminOptional = adminRepository.findById(id);
        if (adminOptional.isPresent()) return adminOptional.get();
        throw new RuntimeException("Value not find with provided id: " + id);
    }

    public Users updateUser(long id, Users user) {
        getById(id);
        user.setId(id);
        return adminRepository.save(user);
    }

    public Users createUser(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return adminRepository.save(user);
    }

    public void deleteUser(long id) {
        adminRepository.deleteById(id);
    }
}
