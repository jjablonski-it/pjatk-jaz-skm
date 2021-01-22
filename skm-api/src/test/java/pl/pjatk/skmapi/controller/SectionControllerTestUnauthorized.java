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
public class SectionControllerTestUnauthorized {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void getAllNotAuthorized() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/section")).andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    public void getByIdNotAuthorized() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/section/1")).andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    public void getByIdNotFoundNotAuthorized() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/section/99")).andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    public void addNotAuthorized() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/section")).andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    public void addBadRequestNotAuthorized() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/section")).andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    public void deleteByIdNotAuthorized() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/section/1")).andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    public void deleteByIdNotFoundNotAuthorized() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/section/99")).andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    public void updateNotAuthorized() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/section")).andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    public void updateNotFoundNotAuthorized() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/section")).andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    public void updateBadRequestNotAuthorized() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/section")).andExpect(MockMvcResultMatchers.status().isForbidden());
    }
}