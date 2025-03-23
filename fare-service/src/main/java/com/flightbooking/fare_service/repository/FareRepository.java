package com.flightbooking.fare_service.repository;

import com.flightbooking.fare_service.model.Fare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface FareRepository extends JpaRepository<Fare, Long> {
    Optional<Fare> findByFlightNumber(String flightNumber);
}