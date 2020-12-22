package pl.pjatk.skmapi.Mvc;

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
public class TrainControllerTest {
//    @Autowired
//    MockMvc mockMvc;
//
//    @Test
//    public void getAll() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/train")).andExpect(MockMvcResultMatchers.status().isOk());
//    }
//
//    @Test
//    public void getById() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/train/1")).andExpect(MockMvcResultMatchers.status().isOk());
//    }
//
//    @Test
//    public void getByIdNotFound() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/train/99")).andExpect(MockMvcResultMatchers.status().isNotFound());
//    }
//
//    @Test
//    public void add() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.post("/train")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("""
//                           {
//                               "forward": 1,
//                               "station": 1
//                           }
//                        """))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }
//
//    @Test
//    public void addBadRequest() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.post("/train")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("""
//                           {
//                               "forward": 1
//                           }
//                        """))
//                .andExpect(MockMvcResultMatchers.status().isBadRequest());
//    }
//
//    @Test
//    public void deleteById() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.delete("/train/1")).andExpect(MockMvcResultMatchers.status().isOk());
//    }
//
//    @Test
//    public void deleteByIdNotFound() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.delete("/train/99")).andExpect(MockMvcResultMatchers.status().isNotFound());
//    }
//
//    @Test
//    public void update() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.put("/train")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("""
//                           {
//                               "id": 1,
//                               "forward": 1
//                           }
//                        """))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }
}
