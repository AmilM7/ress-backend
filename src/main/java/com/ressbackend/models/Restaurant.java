package com.ressbackend.models;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Restaurant {
    private long id;
    private String name;
    private String location;
    private long numOfAvailGuests; /*Number of available Guests*/
    private long numOfAvailTables;
    private String   ressDescription;
    private String contactNum;
    private LocalTime startHour;
    private LocalTime endHour;
    private String email;
    private String contactManager;
    private Type type;
    private String password;


    public void setStartTime(int hours, int minutes, int seconds){
        this.startHour = LocalTime.of(hours,minutes,seconds);
    }

    public void setEndTime(int hours, int minutes, int seconds){
        this.endHour = LocalTime.of(hours,minutes,seconds);


    }
}

