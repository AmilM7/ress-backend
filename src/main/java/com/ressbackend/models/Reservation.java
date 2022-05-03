package com.ressbackend.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Reservation extends User {
    private long id;
    private long numberOfGuests;
    private long time;
    private long tableId;
    private String day;
    private String userFirstName = User.firstName;
}
