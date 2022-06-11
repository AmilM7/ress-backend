package com.ressbackend.controllers;

import com.ressbackend.models.Event;
import com.ressbackend.services.EventService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/events")

public class EventsController {

    private final EventService eventService;

    public EventsController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<Event> getEvents() {
        return this.eventService.getEvents();
    }

    @GetMapping("/id/{id}")
    public Event getEvent(@PathVariable int id) {
        return this.eventService.getById(id);
    }

    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return this.eventService.createEvent(event);
    }
}
