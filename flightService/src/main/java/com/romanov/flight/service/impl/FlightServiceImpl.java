package com.romanov.flight.service.impl;

import com.romanov.flight.exception.NotFoundException;
import com.romanov.flight.model.FlightEntity;
import com.romanov.flight.model.dto.FlightOutput;
import com.romanov.flight.model.dto.PaginationOutput;
import com.romanov.flight.repository.FlightRepository;
import com.romanov.flight.service.FlightService;
import com.romanov.flight.service.mapper.FlightMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {
    private final FlightRepository repository;
    private final FlightMapper mapper;

    @Override
    public FlightOutput getByFlightNumber(String flightNumber) {
        FlightEntity entity = repository.findByFlightNumber(flightNumber)
                .orElseThrow(() -> new NotFoundException("Flight with number: " + flightNumber + " not found!"));
        return mapper.convert(entity);
    }

    @Override
    public PaginationOutput getAll(Integer page, Integer size) {
        Page<FlightOutput> flights = repository
                .findAll(PageRequest.of(page - 1, size))
                .map(mapper::convert);
        return mapper.convert(page, size, flights);
    }
}
