package com.ressbackend.repositories;


import com.ressbackend.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Users, Long> {

    List<Users> findUsersByFirstName(String firstName);

    List<Users> findUsersByLastName(String lastName);
}
