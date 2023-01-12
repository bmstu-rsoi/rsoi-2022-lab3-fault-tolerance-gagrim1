package io.romanov.flightservice.service

import io.romanov.flight_service_api.FlightResponse
import io.romanov.flightservice.PageResponse

interface FlightService {
    suspend fun findFlights(page: Int, size: Int): PageResponse<FlightResponse>
    suspend fun findFlight(flightNumber: String): FlightResponse
}