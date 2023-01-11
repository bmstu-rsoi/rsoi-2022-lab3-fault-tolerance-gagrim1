package com.romanov.gateway.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class AppParams {
    @Value(value = "${host.service.ticket:localhost}")
    private String hostTicket;
    @Value(value = "${host.service.flight:localhost}")
    private String hostFlight;
    @Value(value = "${host.service.bonus:localhost}")
    private String hostBonus;

    @Value(value = "${path.service.ticket:localhost}")
    private String pathTicket;
    @Value(value = "${path.service.flight:localhost}")
    private String pathFlight;
    @Value(value = "${path.service.bonus:localhost}")
    private String pathBonus;

    @Value(value = "${port.service.ticket:localhost}")
    private String portTicket;
    @Value(value = "${port.service.flight:localhost}")
    private String portFlight;
    @Value(value = "${port.service.bonus:localhost}")
    private String portBonus;
}
