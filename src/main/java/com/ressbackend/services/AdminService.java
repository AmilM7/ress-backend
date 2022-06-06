package com.ressbackend.services;

import com.ressbackend.models.Users;
import com.ressbackend.repositories.AdminRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    private final List<Users> userList;
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    public AdminService(AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;

        this.passwordEncoder = passwordEncoder;
        this.createUser(generateAmil());

        userList = new ArrayList<>();
        userList.add(generateAmar());
        userList.add(generateAmil());
        userList.add(generateMirza());
        userList.add(generateIrfan());
    }

    public List<Users> getUsers() {
        return adminRepository.findAll();
    }

    public Users getById(long id) {
        Optional<Users> adminOptional = adminRepository.findById(id);
        if (adminOptional.isPresent()) return adminOptional.get();
        throw new RuntimeException("Value not find with provided id: " + id);
    }

    public List<Users> getByFirstName(String firstName){
        List<Users> firstNameList = new ArrayList<>();
        for (Users user : userList){
            if(user.getFirstName().equals(firstName)){
                firstNameList.add(user);
            }
        }
        if (firstNameList.size()==0) throw new RuntimeException("There is no user by that first name!");
        else return firstNameList;

    }

    public List<Users> getByLastName(String lastName){
        List<Users> lastNameList = new ArrayList<>();
        for (Users user : userList){
            if(user.getLastName().equals(lastName)){
                lastNameList.add(user);
            }
        }
        if (lastNameList.size()==0) throw new RuntimeException("There is no user by that last name!");
        else return lastNameList;

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

    public void deleteUser(long id){
        adminRepository.deleteById(id);
    }

    private Users generateAmar() {
        Users user = new Users();
        user.setId(1);
        user.setFirstName("Amar");
        user.setLastName("Šoše");
        user.setEmail("amar.sose@stu.ssst.edu.ba");
        user.setPhone("061452975");
        user.setPassword("Qwert12345");
        return user;
    }
    private Users generateAmil() {
        Users user = new Users();
        user.setId(2);
        user.setFirstName("Amil");
        user.setLastName("Murselović");
        user.setEmail("amil.murselovic@stu.ssst.edu.ba");
        user.setPhone("061354915");
        user.setPassword("Qwert12345");
        return user;
    }
    private Users generateMirza() {
        Users user = new Users();
        user.setId(3);
        user.setFirstName("Mirza");
        user.setLastName("Arslanagic");
        user.setEmail("mirza.arslanagic@stu.ssst.edu.ba");
        user.setPhone("062451577");
        user.setPassword("Qwert12345");
        return user;
    }
    private Users generateIrfan() {
        Users user = new Users();
        user.setId(4);
        user.setFirstName("Irfan");
        user.setLastName("Parić");
        user.setEmail("irfan.paric@stu.ssst.edu.ba");
        user.setPhone("062654187");
        user.setPassword("Qwert12345");
        return user;
    }



}
