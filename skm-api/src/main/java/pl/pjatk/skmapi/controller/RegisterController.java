package pl.pjatk.skmapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.skmapi.model.User;
import pl.pjatk.skmapi.service.UserService;

@RestController
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity register(@RequestBody User user) {
        System.out.println("register");
        try {
            if (userService.loadUserByUsername(user.getUsername()) != null) {
                return new ResponseEntity(HttpStatus.CONFLICT);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        userService.add(user);
        return new ResponseEntity(HttpStatus.OK);
    }
}
