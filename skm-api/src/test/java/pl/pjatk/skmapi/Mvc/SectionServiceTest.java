package pl.pjatk.skmapi.Mvc;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import pl.pjatk.skmapi.exception.BadRequestException;
import pl.pjatk.skmapi.exception.NotFoundException;
import pl.pjatk.skmapi.model.Section;
import pl.pjatk.skmapi.repository.SectionRepository;
import pl.pjatk.skmapi.service.SectionService;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SectionServiceTest {
    private SectionService sectionService;

    @MockBean
    private SectionRepository sectionRepository;

    @BeforeEach
    public void setUp() {
        sectionService = new SectionService(sectionRepository);
    }

    @Test
    public void getAll() {
        sectionService.getAll();
        Mockito.verify(sectionRepository).findAll();
    }

    @Test
    public void getById() {
        Long id = 1L;
        Mockito.when(sectionRepository.findById(id)).thenReturn(Optional.of(new Section()));

        sectionService.getById(id);
        Mockito.verify(sectionRepository).findById(id);
    }

    @Test
    public void add() {
        Section section = new Section();

        sectionService.add(section);
        Mockito.verify(sectionRepository).save(section);
    }

    @Test
    public void deleteById() {
        Long id = 1L;
        Mockito.when(sectionRepository.findById(id)).thenReturn(Optional.of(new Section()));

        sectionService.deleteById(id);
        Mockito.verify(sectionRepository).deleteById(id);
    }

    @Test
    public void update() throws BadRequestException, NotFoundException {
        Long id = 1L;
        Section section = new Section();
        section.setId(id);

        Optional<Section> optSection = Optional.of(section);

        Mockito.when(sectionRepository.findById(id)).thenReturn(optSection);

        sectionService.update(section);
        Mockito.verify(sectionRepository).save(section);
    }

    @Test()
    public void updateThrowsBadRequestOnEmptyId() {
        Section section = new Section();
        Assert.assertThrows(BadRequestException.class, () -> {
            sectionService.update(section);
        });
    }

    @Test()
    public void updateThrowsNotFoundOnWrongId() {
        Section section = new Section();
        section.setId(1L);
        Assert.assertThrows(NotFoundException.class, () -> {
            sectionService.update(section);
        });
    }
}
