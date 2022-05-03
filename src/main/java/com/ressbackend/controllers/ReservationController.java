package com.ressbackend.controllers;

import com.ressbackend.models.Reservation;
import com.ressbackend.services.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService){
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<Reservation> getReservation(){
        return reservationService.getReservation();
    }

    @GetMapping("/{id}")
    public Reservation getRestaurant(@PathVariable long id){
        return this.reservationService.getById(id);
    }

    @RequestMapping(value="/day/{day}", method = RequestMethod.GET)
    public List<Reservation> getReservationByDay(@PathVariable String day){
        return this.reservationService.getByDay(day);
    }

    @RequestMapping(value="/username/{name}", method = RequestMethod.GET)
    public List<Reservation> getReservationByUsername(@PathVariable String name){
        return this.reservationService.getByUsername(name);
    }

    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationService.createReservation(reservation);
    }

    @DeleteMapping("/{id}")
    public Reservation deleteReservation(@PathVariable long id){
        reservationService.deleteReservation(id);
        return null;
    }

}
