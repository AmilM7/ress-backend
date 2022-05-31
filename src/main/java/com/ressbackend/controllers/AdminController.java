package com.ressbackend.controllers;
import com.ressbackend.models.Users;
import com.ressbackend.services.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/admin")
    public class AdminController {

        private final AdminService adminService;

        public AdminController(AdminService adminService) {
            this.adminService = adminService;
        }

        @GetMapping
        public List<Users> getUsers() {
            return adminService.getUsers();
        }



        @GetMapping("/{id}")
        public Users getUserById(@PathVariable long id) {
            return adminService.getById(id);
        }

        @PutMapping("/update/{id}")
        public Users updateUser(@RequestBody Users user, @PathVariable long id) {
            return adminService.updateUser(user,id);
        }

        @PostMapping
        public Users createUser(@RequestBody Users user) {
            return adminService.createUser(user);
        }

        @DeleteMapping("/admin/{id}")
        public void deleteUser(@PathVariable long id){
            adminService.deleteUser(id);
        }
    }

