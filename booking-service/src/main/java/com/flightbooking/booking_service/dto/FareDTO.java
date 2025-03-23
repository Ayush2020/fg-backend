package com.flightbooking.booking_service.dto;

import lombok.Data;

@Data
public class FareDTO {
    private String flightNumber;
    private Double fareAmount;
    private String currency;
}