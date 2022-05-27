package com.ressbackend.services;

import com.ressbackend.models.Event;
import com.ressbackend.models.Type;
import com.ressbackend.repositories.EventRespository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    private List<Event> finallist;
    private EventRespository eventRespository;


    public EventService(EventRespository eventRespository) {
        this.eventRespository = eventRespository;
        this.finallist = new ArrayList<>();
        this.finallist.add(generateEvent1());
        this.finallist.add(generateEvent2());
    }

    public List<Event> getEvents() {
        return eventRespository.findAll();
    }

    public Event getById(int id) {
        Optional<Event> eventOptional = eventRespository.findById(id);
        if (eventOptional.isPresent()) return eventOptional.get();
        throw new RuntimeException("Value not found with provided id: " + id);
    }

    public List<Event> getOnlyClubs() {
        List<Event> finallist = new ArrayList<>();
        for (Event club : this.finallist) {
            if (club.getType() == Type.club) {
                finallist.add(club);
            }
        }
        return finallist;
    }

    public List<Event> getOnlyRestaurants() {
        List<Event> finallist = new ArrayList<>();
        for (Event restaurant : this.finallist) {
            if (restaurant.getType() == Type.restaurant) {
                finallist.add(restaurant);
            }
        }
        return finallist;
    }

    public Event createEvent(Event event) {
        return eventRespository.save(event);
    }


    private Event generateEvent1() {
        Event event = new Event();
        event.setType(Type.club);
        event.setRestaurantName("Walter");
        event.setEventName("Milica Pavlovic");
        event.setId(1);

        return event;
    }

    private Event generateEvent2() {
        Event event = new Event();
        event.setType(Type.restaurant);
        event.setRestaurantName("Zacin");
        event.setEventName("Riblje vece");
        event.setId(2);
        event.setDate(02022022);
        return event;
    }
}