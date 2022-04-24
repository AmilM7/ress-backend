package com.ressbackend.services;

import com.ressbackend.models.Event;
import com.ressbackend.models.Type;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EventService {
    public List<Event> finallist;

    public EventService() {
        finallist = new ArrayList<>();
        finallist.add(generateEvent1());
        finallist.add(generateEvent2());
    }
    public List<Event> getEvents () {return finallist;}


    public Event getSpecificEvent (int id){
        for (Event event : finallist)
            if (event.getId() == id)
                return event;
        return null;
    }


    public Event getDate (int date){
        for (Event event : finallist)
            if (event.getDate() == date)
                return event;
        return null;
    }

    public Event createEvent (Event event){
        event.setId(finallist.size() + 1);
        finallist.add(event);
        return event;
    }



    public Event deleteEvent(long id){
        for (Event event: finallist)
            if(event.getId() == id) {
                finallist.remove(event);
            }
        return null;
    }
    private Event generateEvent1(){
        Event event = new Event();
        event.setType(Type.club);
        event.setRestaurant_name("Walter");
        event.setEvent_name("Milica Pavlovic");
        event.setId(finallist.size()+1);

        return event;
    }
    private Event generateEvent2(){
        Event event = new Event();
        event.setType(Type.restaurant);
        event.setRestaurant_name("Zacin");
        event.setEvent_name("Riblje vece");
        event.setId(finallist.size()+1);
        event.setDate(02022022);
        return event;
    }
}