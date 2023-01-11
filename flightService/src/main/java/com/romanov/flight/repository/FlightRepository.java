package com.romanov.flight.repository;

import com.romanov.flight.model.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<FlightEntity, Integer> {
    Optional<FlightEntity> findByFlightNumber(String flightNumber);
}
