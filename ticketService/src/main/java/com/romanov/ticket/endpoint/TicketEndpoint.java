package com.romanov.ticket.endpoint;

import com.romanov.ticket.model.dto.TicketInput;
import com.romanov.ticket.model.dto.TicketOutput;
import com.romanov.ticket.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tickets")
@RequiredArgsConstructor
public class TicketEndpoint {
    private final TicketService service;

    @GetMapping
    public List<TicketOutput> getTicketsByUsername(@RequestHeader("X-User-Name") String username) {
        return service.getAllByUsername(username);
    }

    @PostMapping
    public TicketOutput createTicket(@RequestHeader("X-User-Name") String username, @RequestBody TicketInput input) {
        return service.createTicket(username, input);
    }

    @DeleteMapping("/{ticketUid}")
    public TicketOutput cancelTicket(@RequestHeader("X-User-Name") String username, @PathVariable("ticketUid") UUID uid) {
        return service.cancelTicket(username, uid);
    }

    @GetMapping("/{ticketUid}")
    public TicketOutput getTicketByUsernameAndUid(@RequestHeader("X-User-Name") String username,
                                                  @PathVariable("ticketUid") UUID uid) {
        return service.getTicketByUsernameAndUid(username, uid);
    }
}
