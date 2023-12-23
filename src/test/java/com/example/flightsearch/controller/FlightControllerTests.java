package com.example.flightsearch.controller;

import com.example.flightsearch.controller.FlightController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.*;
import org.springframework.security.test.context.support.WithMockUser;


@SpringBootTest
@AutoConfigureMockMvc
public class FlightControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    public void shouldCreateFlight() throws Exception {
        mockMvc.perform(post("/flights")
                        .contentType("application/json")
                        .content("{\"departureAirport\": \"Airport1\", \"arrivalAirport\": \"Airport2\", \"departureTime\": \"2023-01-01T12:00:00\", \"returnTime\": \"2023-01-01T15:00:00\", \"price\": 100}"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Airport1"))); // Bu, dönen cevabın içeriğine bağlı olarak değiştirilmelidir.
    }

}