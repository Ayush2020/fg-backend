package com.flightbooking.fare_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FareDTO {
    private String flightNumber;
    private double fareAmount;
    private String currency;
}