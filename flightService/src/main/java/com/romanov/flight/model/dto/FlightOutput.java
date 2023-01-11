package com.romanov.flight.model.dto;

import lombok.Value;

@Value
public class FlightOutput {
    String flightNumber;
    String date;
    String fromAirport;
    String toAirport;
    Integer price;
}
