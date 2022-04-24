package com.ressbackend.controllers;


import com.ressbackend.models.Event;
import com.ressbackend.services.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/events")

public class EventsController {

    private final EventService eventService;
    private List<Event> finallist = new ArrayList<>();

    public EventsController(EventService eventService){
        this.eventService = eventService;
    }
    @GetMapping

    public List<Event> getEvents () {
        return this.eventService.getEvents();
    }
    @GetMapping("/id/{id}")
    public Event getSpecificEvent (@PathVariable int id){
        return this.eventService.getSpecificEvent(id);
    }

    @GetMapping("/date/{date}")
    public Event getDate (@PathVariable int date){
        return this.eventService.getDate(date);
    }
    @PostMapping
    public Event createPerson (@RequestBody Event event){
        return this.eventService.createEvent(event);
    }
    @DeleteMapping("/delete/{id}")
    public Event deleteEvent(@PathVariable long id){
        eventService.deleteEvent(id);
        return null;
    }
}
