package pl.pjatk.skmapi.controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.skmapi.model.User;
import pl.pjatk.skmapi.repository.UserRepository;
import pl.pjatk.skmapi.service.CrudService;
import pl.pjatk.skmapi.service.UserService;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController extends CrudController<User> {
    UserService userService;

    protected UserController(UserService service) {
        super(service);
        this.userService = service;
    }

    // No time, no DRY
    @PostMapping("/{id}/auth/{auth}")
    public ResponseEntity addAuth(@PathVariable Long id, @PathVariable String auth) {
        try {
            User user = userService.getById(id);
            user.addAuthority(() -> auth);
            userService.save(user);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}/auth/{auth}")
    public ResponseEntity setAuth(@PathVariable Long id, @PathVariable String auth) {
        try {
            User user = userService.getById(id);
            user.setStringAuthority(auth);
            userService.save(user);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{id}/auth/{auth}")
    public ResponseEntity deleteAuth(@PathVariable Long id, @PathVariable String auth) {
        try {
            User user = userService.getById(id);
            user.removeAuthority(() -> auth);
            userService.save(user);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
