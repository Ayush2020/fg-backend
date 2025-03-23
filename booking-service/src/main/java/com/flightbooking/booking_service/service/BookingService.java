package com.flightbooking.booking_service.service;


import com.flightbooking.booking_service.dto.FareDTO;
import com.flightbooking.booking_service.feign.FareServiceClient;
import com.flightbooking.booking_service.model.Booking;
import com.flightbooking.booking_service.repository.BookingRepository;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final FareServiceClient fareServiceClient;

    public BookingService(BookingRepository bookingRepository, FareServiceClient fareServiceClient) {
        this.bookingRepository = bookingRepository;
        this.fareServiceClient = fareServiceClient;
    }

    public Booking createBooking(Booking booking) {
        // Fetch fare from Fare Service
        FareDTO fareDTO = fareServiceClient.getFare(booking.getFlightNumber());
        if (fareDTO != null) {
            booking.setFare(fareDTO.getFareAmount());
            return bookingRepository.save(booking);
        } else {
            throw new RuntimeException("Fare not found for flight: " + booking.getFlightNumber());
        }
    }
}