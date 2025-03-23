package com.flightbooking.checkin_service.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "booking-service", path = "/api/bookings")
public interface BookingServiceClient {

    @GetMapping("/{bookingReference}")
    boolean verifyBooking(@PathVariable String bookingReference);
}
