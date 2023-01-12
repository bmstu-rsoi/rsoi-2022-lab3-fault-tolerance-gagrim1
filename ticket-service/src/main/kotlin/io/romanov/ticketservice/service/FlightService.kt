package io.romanov.ticketservice.service

import io.romanov.flight_service_api.FlightResponse

interface FlightService {
    suspend fun getByFlightNumber(flightNumber: String): FlightResponse
}