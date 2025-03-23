package com.flightbooking.checkin_service.repository;

import com.flightbooking.checkin_service.entity.Checkin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CheckinRepository extends JpaRepository<Checkin, Long> {
    Optional<Checkin> findByBookingReference(String bookingReference);
}