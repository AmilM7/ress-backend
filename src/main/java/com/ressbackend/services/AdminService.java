package com.ressbackend.services;

import com.ressbackend.models.Users;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class AdminService {
    private final List<Users> userList;

    public AdminService() {
        userList = new ArrayList<>();
        userList.add(generateAmar());
        userList.add(generateAmil());
        userList.add(generateMirza());
        userList.add(generateIrfan());
    }

    public List<Users> getUsers() {
        return userList;
    }

    public Users getById(long id) {
        for (Users user : userList) {
            if(user.getId() == id) {
                return user;
            }
        }
        throw new RuntimeException("Value not found provided id:" + id);
    }

    public Users updateUser(Users user) {
        for (Users currentUser: userList) {
            if(currentUser.getId()==user.getId()) {
                currentUser.setId(user.getId());
                currentUser.setFirstName(user.getFirstName());
                currentUser.setLastName(user.getLastName());
                currentUser.setEmail(user.getEmail());
                currentUser.setPhone(user.getPhone());
            }
        }
        return user;

    }

    public Users createUser(Users user) {
        long id = userList.size() + 1;
        user.setId(id);
        userList.add(user);
        return user;
    }



    public Users deleteUser(long id){
        Iterator<Users> iterator = userList.iterator();
        while(iterator.hasNext()) {
            Users user=iterator.next();
            if(user.getId()==id) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }

    private Users generateAmar() {
        Users user = new Users();
        user.setId(1);
        user.setFirstName("Amar");
        user.setLastName("Šoše");
        user.setEmail("amar.sose@stu.ssst.edu.ba");
        user.setPhone("061452975");
        return user;
    }
    private Users generateAmil() {
        Users user = new Users();
        user.setId(2);
        user.setFirstName("Amil");
        user.setLastName("Murselović");
        user.setEmail("amil.murselovic@stu.ssst.edu.ba");
        user.setPhone("061354915");
        return user;
    }
    private Users generateMirza() {
        Users user = new Users();
        user.setId(3);
        user.setFirstName("Mirza");
        user.setLastName("Arslanagic");
        user.setEmail("mirza.arslanagic@stu.ssst.edu.ba");
        user.setPhone("062451577");
        return user;
    }
    private Users generateIrfan() {
        Users user = new Users();
        user.setId(4);
        user.setFirstName("Irfan");
        user.setLastName("Parić");
        user.setEmail("irfan.paric@stu.ssst.edu.ba");
        user.setPhone("062654187");
        return user;
    }



}
