package com.ressbackend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

import javax.persistence.*;

@Entity
@Table(name = "restaurant")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "numOfAvailGuests")
    private long numOfAvailGuests; /*Number of available Guests*/

    @Column(name = "numOfAvailTables")
    private long numOfAvailTables;

    @Column(name = "ressDescription")
    private String ressDescription;

    @Column(name = "contactNum")
    private String contactNum;

    @Column(name = "startHour")
    private LocalTime startHour;

    @Column(name = "endHour")
    private LocalTime endHour;

    @Column(name = "email")
    private String email;

    @Column(name = "contactManager")
    private String contactManager;

    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    private Type type;


    @Column(name = "password")
    private String password;


    public void setStartTime(int hours, int minutes, int seconds) {
        this.startHour = LocalTime.of(hours, minutes, seconds);
    }

    public void setEndTime(int hours, int minutes, int seconds) {
        this.endHour = LocalTime.of(hours, minutes, seconds);


    }
}

