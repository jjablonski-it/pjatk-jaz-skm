package pl.pjatk.skmapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.skmapi.model.Simulation;
import pl.pjatk.skmapi.model.Train;

import java.util.List;


@RestController
public class SkmApiController {
    private Simulation simulation;

    @Autowired
    public SkmApiController(@Value("${envX}") final int x, @Value("${envY}") final int y, @Value("${envZ}") final int z) {
        simulation = new Simulation(x, y, z);
    }

    @GetMapping("/move")

    public void move() {
        simulation.move();
    }

    @GetMapping("/train")
    public List<Object> trains() {

        return simulation.getTrainIds();
    }

    @GetMapping("/train/{id}")
    public Train train(@PathVariable int id) {
        return simulation.getTrains().get(id);
    }

    @GetMapping("/train/{id}/section")
    public List<Object> sections(@PathVariable int id) {
        return simulation.sendSections(id);
    }

    @GetMapping("/train/{trainId}/section/{sectionId}")
    public String section(@PathVariable int trainId, @PathVariable int sectionId) {
        return simulation.sendTrainSection(trainId, sectionId);
    }
}
