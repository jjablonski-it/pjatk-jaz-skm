package pl.pjatk.skmapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.skmapi.model.User;
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
    public void addAuth(@RequestParam Long id, @RequestParam String auth) {
        var user = userService.getById(id);
        user.addAuthority(() -> auth);
    }

    @PutMapping("/{id}/auth/{auth}")
    public void setAuth(@RequestParam Long id, @RequestParam String auth) {
        var user = userService.getById(id);
        user.setStringAuthority(auth);
    }

    @DeleteMapping("/{id}/auth/{auth}")
    public void deleteAuth(@RequestParam Long id, @RequestParam String auth) {
        var user = userService.getById(id);
        user.removeAuthority(() -> auth);
    }

}
