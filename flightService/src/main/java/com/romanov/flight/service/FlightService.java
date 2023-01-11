package com.romanov.flight.service;

import com.romanov.flight.model.dto.FlightOutput;
import com.romanov.flight.model.dto.PaginationOutput;

public interface FlightService {
    FlightOutput getByFlightNumber(String flightNumber);
    PaginationOutput getAll(Integer page, Integer size);
}
