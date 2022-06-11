package com.ressbackend.services;

import com.ressbackend.models.Reservation;
import com.ressbackend.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getReservations() {
        return reservationRepository.findAll();
    }

    public List<Reservation> getReservationByUser(long idUser) {
        return reservationRepository.findReservationByUser_Id(idUser);
    }

    public List<Reservation> getReservationByRestaurant(long idRestaurant) {
        return reservationRepository.findReservationByRestaurant_Id(idRestaurant);
    }

    public List<Reservation> getByDay(String day) {
        return reservationRepository.findReservationsByDay(day);
    }

    public Reservation getById(long id) {
        Optional<Reservation> reservationOptional = reservationRepository.findById(id);
        if (reservationOptional.isPresent()) {
            return reservationOptional.get();
        }
        throw new RuntimeException("Value not find with provided id: " + id);
    }

    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation updateReservation(long id, Reservation reservation) {
        getById(id);
        reservation.setId(id);
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(long id) {
        reservationRepository.deleteById(id);
    }


}