package com.romanov.ticket.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Builder
@Entity
@Table(name = "tickets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "ticket_uid")
    private UUID ticketUid;
    @Column(name = "username")
    private String username;
    @Column(name = "flight_number")
    private String flightNumber;
    @Column(name = "price")
    private Integer price;
    @Column(name = "status")
    private String status; // PAID или CANCELED
}