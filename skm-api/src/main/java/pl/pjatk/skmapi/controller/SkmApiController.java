package pl.pjatk.skmapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.skmapi.model.Section;
import pl.pjatk.skmapi.model.Simulation;
import pl.pjatk.skmapi.model.Train;

import java.util.List;


@RestController
public class SkmApiController {
    private Simulation simulation;


    @Autowired
    public SkmApiController(@Value("${envX}") final int x, @Value("${envY}") final int y, @Value("${envZ}") final int z) {
        simulation = Simulation.getInstance(x, y, z);
    }

    @GetMapping("/")
    public List<Train> trains(){
        return simulation.getTrains();
    }

    @GetMapping("/move")
    public void move() {
        simulation.move();
    }

    @GetMapping("/train")
    public List<Integer> train() {
        return simulation.getTrainIds();
    }

    @GetMapping("/train/{id}")
    public Train train(@PathVariable int id) {
        return simulation.getTrains().get(id);
    }

    @GetMapping("/train/{id}/section")
    public List<Integer> sections(@PathVariable int id) {
        return simulation.getSectionIds(id);
    }

    @GetMapping("/train/{trainId}/section/{sectionId}")
    public Section getSection(@PathVariable int trainId, @PathVariable int sectionId) {
        return simulation.getTrainSection(trainId, sectionId);
    }
}
