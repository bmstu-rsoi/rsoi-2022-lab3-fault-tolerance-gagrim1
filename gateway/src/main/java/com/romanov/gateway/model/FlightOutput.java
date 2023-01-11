package com.romanov.gateway.model;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class FlightOutput {
    String fromAirport;
    String toAirport;
    String date;
}
