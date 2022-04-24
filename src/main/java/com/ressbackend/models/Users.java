package com.ressbackend.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Users {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
