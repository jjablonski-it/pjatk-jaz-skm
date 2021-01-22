package pl.pjatk.skmapi.Service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import pl.pjatk.skmapi.repository.PersonRepository;
import pl.pjatk.skmapi.repository.SectionRepository;
import pl.pjatk.skmapi.repository.TrainRepository;
import pl.pjatk.skmapi.service.SimulationService;

@SpringBootTest
public class SimulationServiceTest {
    private SimulationService simulationService;

    @MockBean
    TrainRepository trainRepository;

    @MockBean
    SectionRepository sectionRepository;

    @MockBean
    PersonRepository personRepository;

    @BeforeEach
    public void setUp() {
        simulationService = new SimulationService(trainRepository, sectionRepository, personRepository);
    }

    @Test
    public void move() {
        simulationService.move();
        Mockito.verify(trainRepository).findAll();
    }
}
