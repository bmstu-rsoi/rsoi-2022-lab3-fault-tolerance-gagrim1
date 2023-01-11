package com.romanov.gateway.service;

import com.romanov.gateway.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;
import java.util.UUID;

public interface GatewayService {
    ResponseEntity<?> getFlights(Integer page, Integer size);
    ResponseEntity<?> getPrivilegeWithHistory(String username);
    UserInfoOutput getUserInfo(String username);
    List<FullTicketOutput> getUserTickets(String username);
    FullTicketOutput getTicketByUid(String username, UUID ticketUid);
    BuyingOutput buyTicket(String username, BuyingInput input);
    void returnTicket(String username, UUID ticketUid);

}
