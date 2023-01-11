package com.romanov.flight.service.mapper;

import com.romanov.flight.model.FlightEntity;
import com.romanov.flight.model.dto.FlightOutput;
import com.romanov.flight.model.dto.PaginationOutput;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class FlightMapper {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public FlightOutput convert(FlightEntity entity) {
        return new FlightOutput(
                entity.getFlightNumber(),
                entity.getDateTime().format(FORMATTER),
                entity.getFromAirport().getCity() + " " + entity.getFromAirport().getName(),
                entity.getToAirport().getCity() + " " + entity.getToAirport().getName(),
                entity.getPrice());
    }

    public PaginationOutput convert(Integer page, Integer pageSize,
                                    Page<FlightOutput> pageable) {
        return new PaginationOutput()
                .setPage(page)
                .setPageSize(pageSize)
                .setTotalElements(pageable.getTotalElements())
                .setItems(pageable.getContent());
    }
}
