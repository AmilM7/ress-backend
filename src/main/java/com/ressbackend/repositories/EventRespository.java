package com.ressbackend.repositories;

import com.ressbackend.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRespository extends JpaRepository<Event, Integer> {


}
