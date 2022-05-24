package com.ressbackend.data;
import com.ressbackend.models.Users;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AdminTest {

    public static Users user1() {
        Users users = new Users();
        users.setId(1L);
        users.setFirstName("Amar");
        users.setLastName("Šoše");
        users.setEmail("amar.sose@stu.ssst.edu.ba");
        users.setPhone("061254197");
        return users;
    }

    public static Users user2() {
        Users users = new Users();
        users.setId(11L);
        users.setFirstName("Mirza");
        users.setLastName("Arslanagić");
        users.setEmail("mirza.arslanagic@stu.ssst.edu.ba");
        users.setPhone("062543987");
        return users;
    }

}
