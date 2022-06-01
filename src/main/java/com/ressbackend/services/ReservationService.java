package com.ressbackend.services;

import com.ressbackend.models.Approval;
import com.ressbackend.models.Reservation;
import com.ressbackend.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private final List<Reservation> resultList;
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
        resultList = new ArrayList<>();
        resultList.add(generateReservation1());
        resultList.add(generateReservation2());
        resultList.add(generateReservation3());
        resultList.add(generateReservation4());

    }

    public List<Reservation> getReservationByTableId(long idUsera) {
        return reservationRepository.findReservationsByTableId(idUsera);
    }

    public List<Reservation> getReservation() {
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

    private Reservation generateReservation1() {
        Reservation reservation = new Reservation();
        reservation.setId(1);
        reservation.setNumberOfGuests(5);
        reservation.setTableId(1);
        reservation.setDay("Monday");
        reservation.setTime(12);
        reservation.setApproval(Approval.pending);
        return reservation;
    }

    private Reservation generateReservation2() {
        Reservation reservation = new Reservation();
        reservation.setId(2);
        reservation.setNumberOfGuests(4);
        reservation.setTableId(13);
        reservation.setDay("Monday");
        reservation.setTime(14);
        reservation.setApproval(Approval.denied);
        return reservation;
    }

    private Reservation generateReservation3() {
        Reservation reservation = new Reservation();
        reservation.setId(3);
        reservation.setNumberOfGuests(6);
        reservation.setTableId(5);
        reservation.setDay("Wednesday");
        reservation.setTime(12);
        reservation.setApproval(Approval.approved);
        return reservation;
    }

    private Reservation generateReservation4() {
        Reservation reservation = new Reservation();
        reservation.setId(4);
        reservation.setNumberOfGuests(2);
        reservation.setTableId(18);
        reservation.setDay("Friday");
        reservation.setTime(13);
        reservation.setApproval(Approval.pending);
        return reservation;
    }

}