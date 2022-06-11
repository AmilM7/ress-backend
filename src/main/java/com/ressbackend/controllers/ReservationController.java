package com.ressbackend.controllers;

import com.ressbackend.models.Approval;
import com.ressbackend.models.Reservation;
import com.ressbackend.services.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<Reservation> getReservation() {
        return reservationService.getReservations();
    }

    @GetMapping("/{id}")
    public Reservation getReservation(@PathVariable long id) {
        return this.reservationService.getById(id);
    }

    @RequestMapping(value = "/day/{day}", method = RequestMethod.GET)
    public List<Reservation> getReservationByDay(@PathVariable String day) {
        return this.reservationService.getByDay(day);
    }

    @GetMapping("/userID/{id}")
    public List<Reservation> getReservationByUserID(@PathVariable long id) {
        return reservationService.getReservationByUser(id);
    }

    @GetMapping("/restaurantID/{id}")
    public List<Reservation> getReservationByRestaurantID(@PathVariable long id) {
        return reservationService.getReservationByRestaurant(id);
    }

    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) {
        reservation.setApproval(Approval.pending);
        return reservationService.createReservation(reservation);
    }

    @PutMapping("/update/{id}")
    public Reservation updateReservationApproved(@PathVariable long id, @RequestBody Reservation reservation) {
        reservation.setApproval(Approval.approved);
        return reservationService.updateReservation(id, reservation);
    }

    @PutMapping("/update2/{id}")
    public Reservation updateReservationDenied(@PathVariable long id, @RequestBody Reservation reservation) {
        reservation.setApproval(Approval.denied);
        return reservationService.updateReservation(id, reservation);
    }

    @DeleteMapping("/{id}")
    public Reservation deleteReservation(@PathVariable long id) {
        reservationService.deleteReservation(id);
        return null;
    }

}