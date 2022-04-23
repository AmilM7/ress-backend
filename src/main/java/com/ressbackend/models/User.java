package com.ressbackend.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private long id;
    protected static String firstName;
    protected static String lastName;
    private long phoneNumber;
}
