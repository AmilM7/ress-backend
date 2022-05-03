package com.ressbackend.repositories;

import com.ressbackend.models.Event;
import com.ressbackend.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRespository extends JpaRepository<Event, Integer> {


}
