package pl.pjatk.skmapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.skmapi.model.User;
import pl.pjatk.skmapi.service.CrudService;

@RestController
@RequestMapping("/user")
public class UserController extends CrudController<User>{
    protected UserController(CrudService<User> service) {
        super(service);
    }
}
