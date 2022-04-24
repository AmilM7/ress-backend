package com.example.demo.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
