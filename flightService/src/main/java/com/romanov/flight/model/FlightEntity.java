package com.romanov.flight.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "flight")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlightEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "flight_number", nullable = false, length = 20)
    private String flightNumber;
    @Column(name = "datetime", nullable = false)
    private LocalDateTime dateTime;
    @ManyToOne
    @JoinColumn(name = "from_airport_id")
    private AirportEntity fromAirport;
    @ManyToOne
    @JoinColumn(name = "to_airport_id")
    private AirportEntity toAirport;
    @Column(name = "price", nullable = false)
    private Integer price;
}
