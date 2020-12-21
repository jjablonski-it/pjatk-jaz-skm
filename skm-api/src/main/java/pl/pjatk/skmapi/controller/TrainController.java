package pl.pjatk.skmapi.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.skmapi.model.Train;
import pl.pjatk.skmapi.service.TrainService;

@RestController
@RequestMapping("/train")
public class TrainController extends CrudController<Train> {
    protected TrainController(TrainService service, TrainService trainService) {
        super(service);
    }
}
