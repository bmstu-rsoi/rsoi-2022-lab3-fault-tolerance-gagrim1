package io.romanov.flightservice.mapper

import io.romanov.flight_service_api.FlightResponse
import io.romanov.flightservice.domain.AirportEntity
import io.romanov.flightservice.domain.FlightEntity

fun FlightEntity.toFlightResponse(fromAirport: AirportEntity, toAirport: AirportEntity) = FlightResponse(
    flightNumber = flightNumber,
    fromAirport = "${fromAirport.city} ${fromAirport.name}",
    toAirport = "${toAirport.city} ${toAirport.name}",
    date = dateTime,
    price = price
)