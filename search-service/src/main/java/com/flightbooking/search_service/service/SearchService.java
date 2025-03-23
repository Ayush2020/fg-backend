package com.flightbooking.search_service.service;

import com.flightbooking.search_service.dto.FlightDTO;
import com.flightbooking.search_service.model.Flight;
import com.flightbooking.search_service.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {

    @Autowired
    private FlightRepository flightRepository;

    public List<FlightDTO> searchFlights(String source, String destination) {
        List<Flight> flights = flightRepository.findBySourceAndDestination(source, destination);
        return flights.stream()
                .map(flight -> new FlightDTO(
                        flight.getFlightNumber(),
                        flight.getAirline(),
                        flight.getSource(),
                        flight.getDestination(),
                        flight.getDepartureTime(),
                        flight.getArrivalTime(),
                        flight.getPrice()
                ))
                .collect(Collectors.toList());
    }
}

