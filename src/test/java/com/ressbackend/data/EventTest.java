package com.ressbackend.data;

import com.ressbackend.models.Event;
import com.ressbackend.models.Type;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EventTest {

    public static Event event() {
        Event event = new Event();
        event.setId(1);
        event.setEventName("Test Restaurant 1");
        event.setType(Type.restaurant);
        event.setDate(02022022);
        return event;
    }

    public static Event event2() {
        Event event = new Event();
        event.setId(2);
        event.setEventName("Test Restaurant 2");
        event.setType(Type.club);
        event.setDate(03022022);
        return event;
    }
}