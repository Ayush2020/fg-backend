package com.flightbooking.search_service.controller;


import com.flightbooking.search_service.dto.FlightDTO;
import com.flightbooking.search_service.exceptions.FlightNotFoundException;
import com.flightbooking.search_service.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/{source}/{destination}")
    public List<FlightDTO> searchFlights(@PathVariable String source, @PathVariable String destination) {
        List<FlightDTO> flights = searchService.searchFlights(source, destination);
        if (flights.isEmpty()) {
            throw new FlightNotFoundException("No flights available from " + source + " to " + destination);
        }
        return flights;
    }
}
