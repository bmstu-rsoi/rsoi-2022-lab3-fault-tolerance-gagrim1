package io.romanov.ticketservice.mapper

import io.romanov.flight_service_api.FlightResponse
import io.romanov.ticket_service_api.TicketResponse
import io.romanov.ticketservice.domain.TicketEntity

fun TicketEntity.toTicketResponse(
    flightResponse: FlightResponse
): TicketResponse = TicketResponse(
    ticketUid = ticketUid,
    flightNumber = flightNumber,
    fromAirport = flightResponse.fromAirport,
    toAirport = flightResponse.toAirport,
    date = flightResponse.date,
    price = price,
    status = status
)
