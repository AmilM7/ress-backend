package com.ressbackend.repositories;

import com.ressbackend.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Users, Long> {
}
