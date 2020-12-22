package pl.pjatk.skmapi.Mvc;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.pjatk.skmapi.exception.BadRequestException;
import pl.pjatk.skmapi.exception.NotFoundException;
import pl.pjatk.skmapi.model.Train;
import pl.pjatk.skmapi.repository.TrainRepository;
import pl.pjatk.skmapi.service.TrainService;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrainServiceTest {
    private TrainService trainService;

    @MockBean
    private TrainRepository trainRepository;

    @BeforeEach
    public void setUp() {
        trainService = new TrainService(trainRepository);
    }

    @Test
    public void getAll() {
        trainService.getAll();
        Mockito.verify(trainRepository).findAll();
    }

    @Test
    public void getById() {
        Long id = 1L;
        Mockito.when(trainRepository.findById(id)).thenReturn(java.util.Optional.of(new Train()));

        trainService.getById(id);
        Mockito.verify(trainRepository).findById(id);
    }

    @Test
    public void add() {
        Train train = new Train();

        trainService.add(train);
        Mockito.verify(trainRepository).save(train);
    }

    @Test
    public void deleteById() {
        Long id = 1L;
        Mockito.when(trainRepository.findById(id)).thenReturn(java.util.Optional.of(new Train()));

        trainService.deleteById(id);
        Mockito.verify(trainRepository).deleteById(id);
    }


}
