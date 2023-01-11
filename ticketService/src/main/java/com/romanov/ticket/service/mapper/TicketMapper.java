package com.romanov.ticket.service.mapper;

import com.romanov.ticket.model.TicketEntity;
import com.romanov.ticket.model.dto.TicketOutput;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {
    public TicketOutput convert(TicketEntity entity) {
        return new TicketOutput(
                entity.getTicketUid(),
                entity.getFlightNumber(),
                entity.getPrice(),
                entity.getStatus());
    }
}
