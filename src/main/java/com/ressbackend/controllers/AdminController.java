package com.ressbackend.controllers;
import com.ressbackend.models.Approval;
import com.ressbackend.models.Reservation;
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
        public Users updateUser(@PathVariable long id, @RequestBody Users user) {
            return adminService.updateUser(id, user);
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

