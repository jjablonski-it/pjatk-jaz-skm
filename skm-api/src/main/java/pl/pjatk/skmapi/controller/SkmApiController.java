package pl.pjatk.skmapi.controller;

import org.springframework.web.bind.annotation.*;
import pl.pjatk.skmapi.model.Simulation;
import pl.pjatk.skmapi.model.Train;

import java.util.List;


@RestController
public class SkmApiController {
    private Simulation simulation;

    public SkmApiController() {
        simulation = new Simulation(2, 4, 2);
    }

    @GetMapping("/move")
    public void move() {
        simulation.move();
    }

    @GetMapping("/train")
    public List<Object> trains(){
        return simulation.getTrainIds();
    }

    @GetMapping("/train/{id}")
    public Train train(@PathVariable int id){
        return simulation.getTrains().get(id);
    }

    @GetMapping("/train/{id}/section")
    public List<Object> sections(@PathVariable int id){
        return simulation.sendSections(id);
    }

    @GetMapping("/train/{trainId}/section/{sectionId}")
    public String section(@PathVariable int trainId, @PathVariable int sectionId){
        return simulation.sendTrainSection(trainId, sectionId);
    }
}
