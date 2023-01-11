package com.romanov.flight;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Sql(value = {
        "/endpoint/flight_init.sql"
},
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/endpoint/truncate_flights.sql",
        executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class FlightApplicationEndpointTest extends EndpointTest {
    @Test
    void shouldReturnFlights() throws Exception {
        mockMvc.perform(get("/flights/all")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("page", "1")
                        .param("size", "10"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.page").value(1))
                .andExpect(jsonPath("$.pageSize").value(10))
                .andExpect(jsonPath("$.totalElements").value(1))
                .andExpect(jsonPath("$.items.[0].flightNumber").value("AFL031"));
    }

    @Test
    void shouldReturnFlightByNumber() throws Exception {
        mockMvc.perform(get("/flights")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("flightNumber", "AFL031"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.flightNumber").value("AFL031"))
                .andExpect(jsonPath("$.date").value("2021-10-08 20:00"));
    }

}
