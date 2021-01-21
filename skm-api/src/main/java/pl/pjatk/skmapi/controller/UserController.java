package pl.pjatk.skmapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.skmapi.model.User;
import pl.pjatk.skmapi.repository.UserRepository;
import pl.pjatk.skmapi.service.CrudService;
import pl.pjatk.skmapi.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController extends CrudController<User> {
    UserService userService;

    protected UserController(UserService service) {
        super(service);
        this.userService = service;
    }

    @PostMapping("/{id}/auth/{auth}")
    public void addAuth(@PathVariable Long id, @PathVariable String auth) {
        var user = userService.getById(id);
        user.addAuthority(() -> auth);
        userService.save(user);
    }

    @PutMapping("/{id}/auth/{auth}")
    public void setAuth(@PathVariable Long id, @PathVariable String auth) {
        var user = userService.getById(id);
        user.setStringAuthority(auth);
        userService.save(user);

    }

    @DeleteMapping("/{id}/auth/{auth}")
    public void deleteAuth(@PathVariable Long id, @PathVariable String auth) {
        var user = userService.getById(id);
        user.removeAuthority(() -> auth);
        userService.save(user);
    }


}
