package pl.pjatk.skmapi.Service;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import pl.pjatk.skmapi.exception.BadRequestException;
import pl.pjatk.skmapi.exception.NotFoundException;
import pl.pjatk.skmapi.model.User;
import pl.pjatk.skmapi.repository.UserRepository;
import pl.pjatk.skmapi.service.UserService;

import java.util.Optional;

@SpringBootTest
public class UserServiceTest {
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        userService = new UserService(userRepository);
    }

    @Test
    public void getAll() {
        userService.getAll();
        Mockito.verify(userRepository).findAll();
    }

    @Test
    public void getById() {
        Long id = 1L;
        Mockito.when(userRepository.findById(id)).thenReturn(Optional.of(new User()));

        userService.getById(id);
        Mockito.verify(userRepository).findById(id);
    }

    @Test
    public void add() {
        User user = new User();
        user.setPassword("pwd");

        userService.add(user);
        Mockito.verify(userRepository).save(user);
    }

    @Test
    public void deleteById() {
        Long id = 1L;
        Mockito.when(userRepository.findById(id)).thenReturn(Optional.of(new User()));

        userService.deleteById(id);
        Mockito.verify(userRepository).deleteById(id);
    }

    @Test
    public void update() throws BadRequestException, NotFoundException {
        Long id = 1L;
        User user = new User();
        user.setId(id);

        Optional<User> optUser = Optional.of(user);

        Mockito.when(userRepository.findById(id)).thenReturn(optUser);

        userService.update(user);
        Mockito.verify(userRepository).save(user);
    }

    @Test()
    public void updateThrowsBadRequestOnEmptyId() {
        User user = new User();
        Assert.assertThrows(BadRequestException.class, () -> {
            userService.update(user);
        });
    }

    @Test()
    public void updateThrowsNotFoundOnWrongId() {
        User user = new User();
        user.setId(1L);
        Assert.assertThrows(NotFoundException.class, () -> {
            userService.update(user);
        });
    }
}
