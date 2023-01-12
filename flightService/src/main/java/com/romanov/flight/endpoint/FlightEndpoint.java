package com.romanov.flight.endpoint;

import com.romanov.flight.model.dto.FlightOutput;
import com.romanov.flight.model.dto.PaginationOutput;
import com.romanov.flight.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/flights", ""})
@RequiredArgsConstructor
public class FlightEndpoint {
    private final FlightService service;

    @GetMapping(value = "/manage/health", produces = "application/json")
    public ResponseEntity<?> isAlive() {
        return ResponseEntity
                .ok()
                .build();
    }

    @GetMapping
    public FlightOutput get(@RequestParam("flightNumber") String flightNumber) {
        return service.getByFlightNumber(flightNumber);
    }

    @GetMapping("/all")
    public PaginationOutput getAll(@RequestParam("page") Integer page,
                                   @RequestParam("size") Integer size) {
        return service.getAll(page, size);
    }
}
