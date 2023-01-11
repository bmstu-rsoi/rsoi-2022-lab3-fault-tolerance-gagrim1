package com.romanov.ticket.repository;

import com.romanov.ticket.model.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Integer> {
    List<TicketEntity> findByUsername(String username);
    Optional<TicketEntity> findByUsernameAndTicketUid(String username, UUID ticketUid);
}
