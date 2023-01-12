package io.romanov.flightservice.service

import io.romanov.common.exception.EntityNotFoundException
import io.romanov.flight_service_api.FlightResponse
import io.romanov.flightservice.PageResponse
import io.romanov.flightservice.domain.AirportEntity
import io.romanov.flightservice.mapper.toFlightResponse
import io.romanov.flightservice.repository.AirportRepository
import io.romanov.flightservice.repository.FlightRepositoryAdapter
import io.romanov.flightservice.toPageResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PersistableFlightService(
        private val flightRepository: FlightRepositoryAdapter,
        private val airportRepository: AirportRepository
): FlightService {
    @Transactional
    override suspend fun findFlights(page: Int, size: Int): PageResponse<FlightResponse> = flightRepository
        .findBy(PageRequest.of(page, size))
        .suspendableMap { flightEntity ->
            val fromAirport = findAirport(flightEntity.fromAirportId)
            val toAirport = findAirport(flightEntity.toAirportId)

            flightEntity.toFlightResponse(fromAirport, toAirport)
        }.toPageResponse()

    @Transactional(readOnly = true)
    override suspend fun findFlight(flightNumber: String): FlightResponse = flightRepository.findByFlightNumber(flightNumber)?.let {
        val fromAirport = findAirport(it.fromAirportId)
        val toAirport = findAirport(it.toAirportId)

        it.toFlightResponse(fromAirport, toAirport)
    } ?: throw EntityNotFoundException("Flight with flightNumber '$flightNumber' not found")

    private suspend fun findAirport(id: Int): AirportEntity = airportRepository.findById(id)
        ?: throw EntityNotFoundException("Airport with id '$id' not found")
}

inline fun <U, T> Page<U>.suspendableMap(converter: (U) -> T): Page<T> {
    val newContent = content.map {
        converter(it)
    }

    return PageImpl(newContent, pageable, totalElements)
}