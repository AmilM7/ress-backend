package com.ressbackend.repositories;

import com.ressbackend.models.Reservation;
import com.ressbackend.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findReservationsByUsername(String username);

    List<Reservation> findReservationsByDay(String day);
}