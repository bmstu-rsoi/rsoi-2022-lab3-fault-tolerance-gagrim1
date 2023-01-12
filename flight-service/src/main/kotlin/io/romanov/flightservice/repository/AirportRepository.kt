package io.romanov.flightservice.repository

import io.romanov.flightservice.domain.AirportEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AirportRepository: CoroutineCrudRepository<AirportEntity, Int>