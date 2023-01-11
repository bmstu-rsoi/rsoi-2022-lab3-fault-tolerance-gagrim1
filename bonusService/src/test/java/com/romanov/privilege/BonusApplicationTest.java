package com.romanov.privilege;

import com.romanov.privilege.model.dto.CalculationPriceInput;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;

import java.util.UUID;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@Sql(value = {
        "/endpoint/privilege_init.sql"
},
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/endpoint/truncate.sql",
        executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class BonusApplicationTest extends EndpointTest {
    @Test
    void shouldReturnPrivilege() throws Exception {
        mockMvc.perform(get("/privileges")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("X-User-Name", "Roman"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.status").value("GOLD"))
                .andExpect(jsonPath("$.balance").value(500));
    }

    @Test
    void shouldReturnPrivilegeWithHistory() throws Exception {
        mockMvc.perform(get("/privileges/with-history")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("X-User-Name", "Roman"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    void shouldCalculatePrice() throws Exception {
        UUID ticketUid = UUID.fromString("d6818ec1-3d27-4a14-b660-1922b14c515d");
        String input = objectMapper.writeValueAsString(new CalculationPriceInput("Roman", ticketUid, 1500, false));
        mockMvc.perform(post("/privileges/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(input))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.paidByMoney").value(1500))
                .andExpect(jsonPath("$.paidByBonuses").value(0))
                .andExpect(jsonPath("$.privilege.status").value("GOLD"))
                .andExpect(jsonPath("$.privilege.balance").value(650));
    }

    @Test
    void shouldReturnWithdrawing() throws Exception {
        mockMvc.perform(delete("/privileges/d6818ec1-3d27-4a14-b660-1922b14c515d")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("X-User-Name", "Roman"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/privileges")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("X-User-Name", "Roman"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.status").value("GOLD"))
                .andExpect(jsonPath("$.balance").value(2000));
    }

    @Test
    void shouldReturnDepositing() throws Exception {
        mockMvc.perform(delete("/privileges/6c10f0e9-170c-4d69-bc8b-56f303e59a10")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("X-User-Name", "Roman"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/privileges")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("X-User-Name", "Roman"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.status").value("GOLD"))
                .andExpect(jsonPath("$.balance").value(300));
    }
}
