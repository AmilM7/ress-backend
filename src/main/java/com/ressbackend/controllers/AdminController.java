package com.ressbackend.controllers;
import com.ressbackend.models.Approval;
import com.ressbackend.models.Reservation;
import com.ressbackend.models.Users;
import com.ressbackend.services.AdminService;
import com.ressbackend.util.JwtUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/admin")
    public class AdminController {

        private final AdminService adminService;
        private final JwtUtil jwtTokenUtil;

        public AdminController(AdminService adminService, JwtUtil jwtTokenUtil) {
            this.adminService = adminService;
            this.jwtTokenUtil = jwtTokenUtil;
        }

        @GetMapping
        public List<Users> getUsers() {
            return adminService.getUsers();
        }

     /*   @GetMapping("/whoami")
        public Users getUser (RequestHeader(name = 'Authorization') String token){
            String email = jwtTokenUtil.extractUsername(token.substring(7));
            Users users = adminService.getByEmaill(email);
            return users;
        }
*/

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

