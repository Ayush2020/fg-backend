package com.flightbooking.fare_service.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "fares")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Fare {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String flightNumber;
    private double fareAmount;
    private String currency;
}