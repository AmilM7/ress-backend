package com.ressbackend.controllers;
import com.ressbackend.models.Users;
import com.ressbackend.models.entities.UserEntity;
import com.ressbackend.repositories.AdminRepository;
import com.ressbackend.repositories.UserRepository;
import com.ressbackend.util.JwtUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class UserController {
    private final JwtUtil jwtUtil;
    private final AdminRepository adminRepository;

    public UserController(JwtUtil jwtUtil, AdminRepository adminRepository) {
        this.jwtUtil = jwtUtil;
        this.adminRepository = adminRepository;
    }
    @GetMapping()
    public Users getAppUser(@RequestHeader ( name = "Authorization") String token){
        String email = jwtUtil.extractUsername(token.substring(7));
        Users user = adminRepository.findByEmail(email);
        return user;
    }

}
