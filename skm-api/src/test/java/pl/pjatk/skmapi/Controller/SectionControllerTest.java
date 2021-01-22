package pl.pjatk.skmapi.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class SectionControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void getAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/section")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/section/1")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getByIdNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/section/99")).andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void add() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/section")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                           {
                               "train": {
                                   "id": 1
                               },
                               "maxSeats": 99,
                               "people": []
                           }
                        """))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void addBadRequest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/section")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                           {
                               "maxSeats": 99,
                               "people": []
                           }
                        """))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void deleteById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/section/1")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void deleteByIdNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/section/99")).andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void update() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/section")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                           {
                               "id": 1,
                               "maxSeats": 1
                           }
                        """))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void updateNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/section")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                           {
                               "id": 99,
                               "maxSeats": 1
                           }
                        """))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void updateBadRequest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/section")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                           {
                               "maxSeats": 1
                           }
                        """))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}
