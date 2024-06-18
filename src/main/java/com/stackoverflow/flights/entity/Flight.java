package com.stackoverflow.flights.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "Flight")
@Table(name = "flights", catalog = "flightdb")
@Data
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "flightid")
    private Long flightId;
    @Column(name = "originairport")
    private String originAirport;
    @Column(name = "destinationairport")
    private String destinationAirport;
}
