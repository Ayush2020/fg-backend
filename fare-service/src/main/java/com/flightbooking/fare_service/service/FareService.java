package com.flightbooking.fare_service.service;


import com.flightbooking.fare_service.dto.FareDTO;
import com.flightbooking.fare_service.exception.FareNotFoundException;
import com.flightbooking.fare_service.model.Fare;
import com.flightbooking.fare_service.repository.FareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FareService {

    @Autowired
    private FareRepository fareRepository;

    public FareDTO getFareByFlightNumber(String flightNumber) {
        Fare fare = fareRepository.findByFlightNumber(flightNumber)
                .orElseThrow(() -> new FareNotFoundException("Fare details not found for flight " + flightNumber));

        return new FareDTO(fare.getFlightNumber(), fare.getFareAmount(), fare.getCurrency());
    }
}
