package com.ressbackend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name = "reservation")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "number_of_guests")
    private long numberOfGuests;

    @Column(name = "time")
    private LocalTime time;

    @Column(name = "table_id")
    private long tableId;

    @Column(name = "day")
    private String day;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "admin", referencedColumnName = "id")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "restaurant", referencedColumnName = "id")
    private Restaurant restaurant;

    @Column(name = "approval")
    @Enumerated(value = EnumType.STRING)
    private Approval approval;
}