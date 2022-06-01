package com.ressbackend.data;

import com.ressbackend.models.Reservation;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReservationTest {

    public static Reservation reservation() {
        Reservation reservation = new Reservation();
        reservation.setId(10L);
        reservation.setDay("Monday");
        reservation.setTableId(57L);
        reservation.setNumberOfGuests(3L);
        reservation.setTime(12L);
        return reservation;
    }

    public static Reservation reservation2() {
        Reservation reservation = new Reservation();
        reservation.setId(11L);
        reservation.setDay("Wednesday");
        reservation.setTableId(30L);
        reservation.setNumberOfGuests(2L);
        reservation.setTime(13L);
        return reservation;
    }

}




