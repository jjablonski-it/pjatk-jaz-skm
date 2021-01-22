package pl.pjatk.skmapi.controller.user;

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

import javax.transaction.Transactional;

import static pl.pjatk.skmapi.security.util.SecurityConstants.HEADER_STRING;
import static pl.pjatk.skmapi.security.util.SecurityConstants.TOKEN_PREFIX;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Transactional
public class UserControllerTestUnauthorized {
    @Autowired
    MockMvc mockMvc;

    String TOKEN = "";

    @Test
    public void getAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user").header(HEADER_STRING, TOKEN)).andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    public void getById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/1").header(HEADER_STRING, TOKEN)).andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    public void getByIdNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/99").header(HEADER_STRING, TOKEN)).andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    public void add() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/user")
                .header(HEADER_STRING, TOKEN)
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                           {
                               "login":"login",
                               "password":"password"
                           }
                        """))
                .andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    public void addBadRequest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/user")
                .header(HEADER_STRING, TOKEN)
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                           {
                               "login": "login",
                           }
                        """))
                .andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    public void deleteById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/user/1").header(HEADER_STRING, TOKEN)).andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    public void deleteByIdNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/user/99").header(HEADER_STRING, TOKEN)).andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    public void update() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/user")
                .header(HEADER_STRING, TOKEN)
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                           {
                               "id": 1,
                               "login": "updated"
                           }
                        """))
                .andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    public void updateNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .header(HEADER_STRING, TOKEN)
                .content("""
                           {
                               "id": 99,
                               "login": "updated"
                           }
                        """))
                .andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    public void updateBadRequest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/user")
                .header(HEADER_STRING, TOKEN)
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                           {
                               "login": "updated"
                           }
                        """))
                .andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    public void addAuthority() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/user/1/auth/ROLE_ADMIN")
                .header(HEADER_STRING, TOKEN))
                .andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    public void removeAuthority() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/user/1/auth/ROLE_ADMIN")
                .header(HEADER_STRING, TOKEN))
                .andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    public void setAuthority() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/user/1/auth/ROLE_ADMIN")
                .header(HEADER_STRING, TOKEN))
                .andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    public void addAuthorityNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/user/9/auth/ROLE_ADMIN")
                .header(HEADER_STRING, TOKEN))
                .andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    public void removeAuthorityNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/user/9/auth/ROLE_ADMIN")
                .header(HEADER_STRING, TOKEN))
                .andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    public void setAuthorityNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/user/9/auth/ROLE_ADMIN")
                .header(HEADER_STRING, TOKEN))
                .andExpect(MockMvcResultMatchers.status().isForbidden());
    }
}
