package com.ressbackend.repositories;

import com.ressbackend.models.Reservation;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findReservationsByDay(String day);
    List<Reservation> findReservationsByTableId(long id);
}