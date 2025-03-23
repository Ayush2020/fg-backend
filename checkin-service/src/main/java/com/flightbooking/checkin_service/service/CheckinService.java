package com.flightbooking.checkin_service.service;

import com.flightbooking.checkin_service.dto.CheckinRequest;
import com.flightbooking.checkin_service.entity.Checkin;
import com.flightbooking.checkin_service.exception.ResourceNotFoundException;
import com.flightbooking.checkin_service.feign.BookingServiceClient;
import com.flightbooking.checkin_service.repository.CheckinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CheckinService {

    @Autowired
    private CheckinRepository checkinRepository;

    @Autowired
    private BookingServiceClient bookingServiceClient;

    public String checkInPassenger(CheckinRequest request) {
        // Verify booking with Booking Service
        boolean isBookingValid = bookingServiceClient.verifyBooking(request.getBookingReference());
        if (!isBookingValid) {
            throw new ResourceNotFoundException("Booking not found for reference: " + request.getBookingReference());
        }

        // Check if already checked in
        Optional<Checkin> existingCheckin = checkinRepository.findByBookingReference(request.getBookingReference());
        if (existingCheckin.isPresent()) {
            return "Passenger already checked in!";
        }

        // Perform check-in
        Checkin checkin = Checkin.builder()
                .bookingReference(request.getBookingReference())
                .passengerName("Passenger Name") // Can fetch from Booking Service if needed
                .checkedIn(true)
                .build();

        checkinRepository.save(checkin);
        return "Check-in successful for booking reference: " + request.getBookingReference();
    }
}
