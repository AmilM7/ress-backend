package com.ressbackend.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Event {
    private int id;
    private String restaurant_name;
    private String event_name;
    private int date;
    private Type type;
}
