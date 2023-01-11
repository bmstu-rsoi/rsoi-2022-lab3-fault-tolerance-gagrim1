package com.romanov.ticket.service.impl;

import com.romanov.ticket.exception.NotFoundException;
import com.romanov.ticket.model.TicketEntity;
import com.romanov.ticket.model.dto.TicketInput;
import com.romanov.ticket.model.dto.TicketOutput;
import com.romanov.ticket.repository.TicketRepository;
import com.romanov.ticket.service.TicketService;
import com.romanov.ticket.service.mapper.TicketMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final TicketRepository repository;
    private final TicketMapper mapper;

    @Override
    public List<TicketOutput> getAllByUsername(String username) {
        return repository.findByUsername(username)
                .stream()
                .map(mapper::convert)
                .collect(Collectors.toList());
    }

    @Override
    public TicketOutput createTicket(String username, TicketInput input) {
        TicketEntity entity = TicketEntity.builder()
                .ticketUid(UUID.randomUUID())
                .username(username)
                .flightNumber(input.getFlightNumber())
                .price(input.getPrice())
                .status("PAID")
                .build();
        entity = repository.save(entity);
        return mapper.convert(entity);
    }

    @Override
    public TicketOutput cancelTicket(String username, UUID uid) {
        TicketEntity entity = repository.findByUsernameAndTicketUid(username, uid)
                .orElseThrow(() -> new NotFoundException(
                        "Ticket with uid: " + uid + " and customer: " + username + " not found!")
                );
        entity.setStatus("CANCELED");
        repository.save(entity);
        return mapper.convert(entity);
    }

    @Override
    public TicketOutput getTicketByUsernameAndUid(String username, UUID uid) {
        TicketEntity entity = repository.findByUsernameAndTicketUid(username, uid)
                .orElseThrow(() -> new NotFoundException(
                        "Ticket with uid: " + uid + " and customer: " + username + " not found!")
                );
        return mapper.convert(entity);
    }
}
