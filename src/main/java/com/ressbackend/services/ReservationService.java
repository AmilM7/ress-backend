package com.ressbackend.services;

import com.ressbackend.models.Reservation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {

    private final List<Reservation> resultList;

    public ReservationService(){
        resultList = new ArrayList<>();
        resultList.add(generateReservation1());
        resultList.add(generateReservation2());
        resultList.add(generateReservation3());
        resultList.add(generateReservation4());
    }

    public List<Reservation> getReservation(){
        return resultList;
    }

    public List<Reservation> getByDay(String day){
        List<Reservation> dayList = new ArrayList<>();
        for (Reservation reservation : resultList){
            if(reservation.getDay().equals(day)){
                dayList.add(reservation);
            }
        }
        if (dayList.size()==0) throw new RuntimeException("There is no reservations on that Day!");
        return dayList;
    }

    public List<Reservation> getByUsername(String name){
        List<Reservation> usernameList = new ArrayList<>();
        for (Reservation reservation : resultList){
            if(reservation.getUserFirstName().equals(name)){
                usernameList.add(reservation);
            }
        }
        if (usernameList.size()==0) throw new RuntimeException("There is no reservations on that User!");
        else return usernameList;

    }

    public Reservation getById(long id){
        for (Reservation reservation : resultList){
            if (reservation.getId() == id){
                return reservation;
            }
        }
        throw new RuntimeException("There is no restaurant with wanted id!");
    }


    public Reservation createReservation(Reservation reservation) {
        long id = resultList.size() + 1;
        reservation.setId(id);
        resultList.add(reservation);
        return reservation;
    }

    public void deleteReservation(long id){
        resultList.removeIf(reservation -> reservation.getId() == id);
    }

    private Reservation generateReservation1() {
        Reservation reservation = new Reservation();
        reservation.setId(1);
        reservation.setNumberOfGuests(5);
        reservation.setTableId(1);
        reservation.setDay("Monday");
        reservation.setTime(12);
        reservation.setUserFirstName("Amar");
        return reservation;
    }

    private Reservation generateReservation2() {
        Reservation reservation = new Reservation();
        reservation.setId(2);
        reservation.setNumberOfGuests(4);
        reservation.setTableId(13);
        reservation.setDay("Monday");
        reservation.setTime(14);
        reservation.setUserFirstName("Amar");
        return reservation;
    }

    private Reservation generateReservation3() {
        Reservation reservation = new Reservation();
        reservation.setId(3);
        reservation.setNumberOfGuests(6);
        reservation.setTableId(5);
        reservation.setDay("Wednesday");
        reservation.setTime(12);
        reservation.setUserFirstName("Amil");
        return reservation;
    }

    private Reservation generateReservation4() {
        Reservation reservation = new Reservation();
        reservation.setId(4);
        reservation.setNumberOfGuests(2);
        reservation.setTableId(18);
        reservation.setDay("Friday");
        reservation.setTime(13);
        reservation.setUserFirstName("Mirza");
        return reservation;
    }

}
