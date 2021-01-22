package pl.pjatk.skmapi.Controller.Section;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static pl.pjatk.skmapi.security.util.SecurityConstants.HEADER_STRING;
import static pl.pjatk.skmapi.security.util.SecurityConstants.TOKEN_PREFIX;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SectionControllerTestPrivileged {
    @Autowired
    MockMvc mockMvc;

    String TOKEN;

    @BeforeAll
    public void setUp() throws Exception {
        var response = mockMvc.perform(MockMvcRequestBuilders.get("/login").contentType(MediaType.APPLICATION_JSON)
                .content("""
                           {
                             "login": "privileged",
                             "password": "123"
                           }
                        """)).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        String content = response.getResponse().getContentAsString();
        String token = content.split(" ")[1];
        this.TOKEN = TOKEN_PREFIX + token;
    }

    @Test
    public void getAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/section").header(HEADER_STRING, TOKEN)).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/section/1").header(HEADER_STRING, TOKEN)).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getByIdNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/section/99").header(HEADER_STRING, TOKEN)).andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void add() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/section")
                .header(HEADER_STRING, TOKEN)
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
                .andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    public void addBadRequest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/section")
                .header(HEADER_STRING, TOKEN)
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                           {
                               "maxSeats": 99,
                               "people": []
                           }
                        """))
                .andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    public void deleteById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/section/1").header(HEADER_STRING, TOKEN)).andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    public void deleteByIdNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/section/99").header(HEADER_STRING, TOKEN)).andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    public void update() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/section")
                .header(HEADER_STRING, TOKEN)
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                           {
                               "id": 1,
                               "maxSeats": 1
                           }
                        """))
                .andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    public void updateNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/section")
                .contentType(MediaType.APPLICATION_JSON)
                .header(HEADER_STRING, TOKEN)
                .content("""
                           {
                               "id": 99,
                               "maxSeats": 1
                           }
                        """))
                .andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    public void updateBadRequest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/section")
                .header(HEADER_STRING, TOKEN)
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                           {
                               "maxSeats": 1
                           }
                        """))
                .andExpect(MockMvcResultMatchers.status().isForbidden());
    }
}
