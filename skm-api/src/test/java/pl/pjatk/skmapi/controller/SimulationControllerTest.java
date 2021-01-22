package pl.pjatk.skmapi.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class SimulationControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void move() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/move")).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
