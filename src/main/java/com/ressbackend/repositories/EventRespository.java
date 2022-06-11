package com.ressbackend.repositories;

import com.ressbackend.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EventRespository extends JpaRepository<Event, Integer> {
    List<Event> findEventByType(String type);
}
