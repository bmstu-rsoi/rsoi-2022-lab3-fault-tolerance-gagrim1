package com.romanov.ticket;

import com.romanov.ticket.model.dto.TicketInput;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@Sql(value = {
        "/endpoint/ticket_init.sql"
},
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/endpoint/truncate.sql",
        executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class TicketApplicationTest extends EndpointTest {

    @Test
    void shouldReturnTickets() throws Exception {
        mockMvc.perform(get("/tickets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("X-User-Name", "Roman"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", hasSize(2)))

                .andExpect(jsonPath("$.[0].ticketUid").value("d6818ec1-3d27-4a14-b660-1922b14c515d"))
                .andExpect(jsonPath("$.[0].flightNumber").value("AFL031"))
                .andExpect(jsonPath("$.[0].price").value(1500))
                .andExpect(jsonPath("$.[0].status").value("PAID"))

                .andExpect(jsonPath("$.[1].ticketUid").value("6c10f0e9-170c-4d69-bc8b-56f303e59a10"))
                .andExpect(jsonPath("$.[1].flightNumber").value("AFL040"))
                .andExpect(jsonPath("$.[1].price").value(1500))
                .andExpect(jsonPath("$.[1].status").value("PAID"));
    }

    @Test
    void shouldReturnTicketByUsernameAndUuid() throws Exception {
        mockMvc.perform(get("/tickets/8d456c13-a60a-4d34-9db2-3965078c4045")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("X-User-Name", "Yuri"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))

                .andExpect(jsonPath("$.ticketUid").value("8d456c13-a60a-4d34-9db2-3965078c4045"))
                .andExpect(jsonPath("$.flightNumber").value("AFL031"))
                .andExpect(jsonPath("$.price").value(1500))
                .andExpect(jsonPath("$.status").value("PAID"));
    }

    @Test
    void shouldCancelTicket() throws Exception {
        mockMvc.perform(get("/tickets/8d456c13-a60a-4d34-9db2-3965078c4045")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("X-User-Name", "Yuri"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))

                .andExpect(jsonPath("$.ticketUid").value("8d456c13-a60a-4d34-9db2-3965078c4045"))
                .andExpect(jsonPath("$.status").value("PAID"));

        mockMvc.perform(delete("/tickets/8d456c13-a60a-4d34-9db2-3965078c4045")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("X-User-Name", "Yuri"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))

                .andExpect(jsonPath("$.ticketUid").value("8d456c13-a60a-4d34-9db2-3965078c4045"))
                .andExpect(jsonPath("$.status").value("CANCELED"));
    }

    @Test
    void shouldCreateTicket() throws Exception {
        String input = objectMapper.writeValueAsString(new TicketInput("AFL040", 1500));

        mockMvc.perform(post("/tickets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("X-User-Name", "Yuri").content(input))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.ticketUid").exists())
                .andExpect(jsonPath("$.flightNumber").value("AFL040"))
                .andExpect(jsonPath("$.price").value(1500))
                .andExpect(jsonPath("$.status").value("PAID"));

    }

}
