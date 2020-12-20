package pl.pjatk.skmapi.controller;

import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.skmapi.model.Train;
import pl.pjatk.skmapi.service.CrudService;

@RestController("/train")
public class TrainController extends CrudController<Train>{
    protected TrainController(CrudService<Train> service) {
        super(service);
    }
}
