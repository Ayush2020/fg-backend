package com.flightbooking.fare_service.exception;

public class FareNotFoundException extends RuntimeException {
    public FareNotFoundException(String message) {
        super(message);
    }
}