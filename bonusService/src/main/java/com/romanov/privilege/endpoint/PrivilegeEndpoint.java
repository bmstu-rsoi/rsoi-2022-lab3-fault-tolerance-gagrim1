package com.romanov.privilege.endpoint;

import com.romanov.privilege.model.dto.*;
import com.romanov.privilege.service.PrivilegeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/privileges")
@RequiredArgsConstructor
public class PrivilegeEndpoint {
    private final PrivilegeService service;

    @GetMapping
    public PrivilegeOutput get(@RequestHeader("X-User-Name") String username) {
        return service.get(username);
    }

    @GetMapping("/with-history")
    public PrivilegeWithHistoryOutput getWithHistory(@RequestHeader("X-User-Name") String username) {
        return service.getWithHistory(username);
    }

    @PostMapping("/calculate")
    public BonusOutput calculatePrice(@RequestBody CalculationPriceInput input) {
        return service.calculatePrice(input);
    }

    @DeleteMapping("/{ticketUid}")
    public void returnBonus(@RequestHeader("X-User-Name") String username,
                            @PathVariable("ticketUid") UUID ticketUid) {
        service.returnBonus(username, ticketUid);
    }
}
