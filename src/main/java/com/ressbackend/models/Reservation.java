package com.ressbackend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="reservation")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Reservation extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "number_of_guests")
    private long numberOfGuests;

    @Column(name = "time")
    private long time;

    @Column(name = "table_id")
    private long tableId;

    @Column(name = "day")
    private String day;

    @Column(name = "user_first_name")
    private String userFirstName = User.firstName;

    @Column(name = "user_last_name")
    private String userLastName = User.lastName;

    @Column(name = "approval")
    @Enumerated(value = EnumType.STRING)
    private Approval approval;
}