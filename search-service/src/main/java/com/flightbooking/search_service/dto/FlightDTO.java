package com.flightbooking.search_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightDTO {

    private String flightNumber;

    private String airline;

    private String source;

    private String destination;

    private String departureTime;

    private String arrivalTime;

    private double price;
}
