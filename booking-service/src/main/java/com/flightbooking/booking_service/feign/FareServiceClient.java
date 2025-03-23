package com.flightbooking.booking_service.feign;

import com.flightbooking.booking_service.dto.FareDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "fare-service", url = "http://localhost:8082/api/fares")
public interface FareServiceClient {
    @GetMapping("/get/{flightNumber}")
    FareDTO getFare(@PathVariable String flightNumber);
}
