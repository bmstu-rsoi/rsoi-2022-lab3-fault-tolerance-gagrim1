package com.romanov.gateway.repository;

import com.romanov.gateway.config.AppParams;
import com.romanov.gateway.exception.FlightServiceNotAvailableException;
import com.romanov.gateway.exception.GatewayErrorException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RequiredArgsConstructor
public class FlightRepository extends Repository {
    public ResponseEntity<?> getFlights(Integer page, Integer size) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .host(params.getHostFlight())
                        .path(params.getPathFlight() + "/all")
                        .port(params.getPortFlight())
                        .queryParam("page", page)
                        .queryParam("size", size)
                        .build())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .onStatus(HttpStatus::isError, error -> {
                    throw new FlightServiceNotAvailableException(error.statusCode());
                })
                .toEntity(Object.class)
                .onErrorMap(Throwable.class, error -> {
                    throw new GatewayErrorException(error.getMessage());
                })
                .block();
    }
}
