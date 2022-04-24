package com.example.demo.controllers;
import com.example.demo.models.User;
import com.example.demo.services.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/admin")
    public class AdminController {

        private final AdminService adminService;

        public AdminController(AdminService itemService) {
            this.adminService = itemService;
        }

        @GetMapping
        public List<User> getUsers() {
            return adminService.getUsers();
        }

        @GetMapping("/{id}")
        public User getUserById(@PathVariable long id) {
            return adminService.getById(id);
        }

        @PutMapping("/update")
        public User updateUser(@RequestBody User user) {
            return adminService.updateUser(user);
        }

        @PostMapping
        public User createUser(@RequestBody User user) {
            return adminService.createUser(user);
        }

        @DeleteMapping("/admin/{id}")
        public User deleteUser(@PathVariable long id){
            return adminService.deleteUser(id);
        }
    }

