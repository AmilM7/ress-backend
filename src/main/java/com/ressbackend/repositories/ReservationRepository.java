package com.ressbackend.repositories;

import com.ressbackend.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findReservationsByDay(String day);

    List<Reservation> findReservationByUser_Id(long idUsera);

    List<Reservation> findReservationByRestaurant_Id(long idRestorana);

}