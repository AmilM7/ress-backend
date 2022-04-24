package com.example.demo.services;

import com.example.demo.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class AdminService {
    private final List<User> userList;

    public AdminService() {
        userList = new ArrayList<>();
        userList.add(generateAmar());
        userList.add(generateAmil());
        userList.add(generateMirza());
        userList.add(generateIrfan());
    }

    public List<User> getUsers() {
        return userList;
    }

    public User getById(long id) {
        for (User user : userList) {
            if(user.getId() == id) {
                return user;
            }
        }
        throw new RuntimeException("Value not found provided id:" + id);
    }

    public User updateUser(User user) {
        for (User currentUser: userList) {
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

    public User createUser(User user) {
        long id = userList.size() + 1;
        user.setId(id);
        userList.add(user);
        return user;
    }



    public User deleteUser(long id){
        Iterator<User> iterator = userList.iterator();
        while(iterator.hasNext()) {
            User user=iterator.next();
            if(user.getId()==id) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }

    private User generateAmar() {
        User user = new User();
        user.setId(1);
        user.setFirstName("Amar");
        user.setLastName("Šoše");
        user.setEmail("amar.sose@stu.ssst.edu.ba");
        user.setPhone("061452975");
        return user;
    }
    private User generateAmil() {
        User user = new User();
        user.setId(2);
        user.setFirstName("Amil");
        user.setLastName("Murselović");
        user.setEmail("amil.murselovic@stu.ssst.edu.ba");
        user.setPhone("061354915");
        return user;
    }
    private User generateMirza() {
        User user = new User();
        user.setId(3);
        user.setFirstName("Mirza");
        user.setLastName("Arslanagic");
        user.setEmail("mirza.arslanagic@stu.ssst.edu.ba");
        user.setPhone("062451577");
        return user;
    }
    private User generateIrfan() {
        User user = new User();
        user.setId(4);
        user.setFirstName("Irfan");
        user.setLastName("Parić");
        user.setEmail("irfan.paric@stu.ssst.edu.ba");
        user.setPhone("062654187");
        return user;
    }



}
