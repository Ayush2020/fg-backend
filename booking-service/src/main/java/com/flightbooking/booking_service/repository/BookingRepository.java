package com.flightbooking.booking_service.repository;


import com.flightbooking.booking_service.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByFlightNumber(String flightNumber);
}
