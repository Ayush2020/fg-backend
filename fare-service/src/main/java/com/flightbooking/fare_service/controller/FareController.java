package com.flightbooking.fare_service.controller;


import com.flightbooking.fare_service.dto.FareDTO;
import com.flightbooking.fare_service.service.FareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fares")
public class FareController {

    @Autowired
    private FareService fareService;

    @GetMapping("/get/{flightNumber}")
    public FareDTO getFare(@PathVariable String flightNumber) {
        return fareService.getFareByFlightNumber(flightNumber);
    }
}