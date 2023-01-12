package com.romanov.gateway.endpoint;

import com.romanov.gateway.model.*;
import com.romanov.gateway.service.GatewayService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping({"/api/v1", ""})
@RequiredArgsConstructor
public class GatewayEndpoint {
    private static final String USERNAME_PARAM = "X-User-Name";

    private final GatewayService service;

    @GetMapping(value = "/manage/health", produces = "application/json")
    public ResponseEntity<?> isAlive() {
        return ResponseEntity
                .ok()
                .build();
    }

    @GetMapping("/flights")
    public ResponseEntity<?> getFlights(@RequestParam("page") Integer page,
                                        @RequestParam("size") Integer size) {
        return service.getFlights(page, size);
    }

    @GetMapping("/privilege")
    public ResponseEntity<?> getPrivilegeWithHistory(@RequestHeader(USERNAME_PARAM) String username) {
        return service.getPrivilegeWithHistory(username);
    }

    @GetMapping("/me")
    public UserInfoOutput getUserInfo(@RequestHeader(USERNAME_PARAM) String username) {
        return service.getUserInfo(username);
    }

    @GetMapping("/tickets")
    public List<FullTicketOutput> getUserTickets(@RequestHeader(USERNAME_PARAM) String username) {
        return service.getUserTickets(username);
    }

    @GetMapping("/tickets/{ticketUid}")
    public FullTicketOutput getTicketByUid(@RequestHeader(USERNAME_PARAM) String username,
                                           @PathVariable("ticketUid") UUID ticketUid) {
        return service.getTicketByUid(username, ticketUid);
    }

    @PostMapping("/tickets")
    public BuyingOutput buyTicket(@RequestHeader(USERNAME_PARAM) String username,
                                  @RequestBody BuyingInput input) {
        return service.buyTicket(username, input);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/tickets/{ticketUid}")
    public void returnTicket(@RequestHeader(USERNAME_PARAM) String username,
                             @PathVariable("ticketUid") UUID ticketUid) {
            service.returnTicket(username, ticketUid);
    }
}
