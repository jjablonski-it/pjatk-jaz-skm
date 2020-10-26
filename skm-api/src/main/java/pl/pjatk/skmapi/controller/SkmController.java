package pl.pjatk.skmapi.controller;

import org.springframework.web.bind.annotation.*;
import pl.pjatk.skmapi.model.Simulation;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@RestController
public class SkmController {
    private Simulation simulation;

    public SkmController() {
        simulation = new Simulation(2, 4, 2);
    }

    @GetMapping("/status")
    public String getStatus() {
        return simulation.getJsonStringStatus();
    }

    @GetMapping("/move")
    public String move() {
        simulation.move();
        return simulation.getJsonStringStatus();
    }

    @GetMapping("/train")
    public String trains(){
        return simulation.sendTrains();
    }

    @GetMapping("/train/{id}")
    public String train(@PathVariable int id){
        return simulation.sendTrain(id);
    }

    @GetMapping("/train/{id}/section")
    public String sections(@PathVariable int id){
        return simulation.sendSections(id);
    }

    @GetMapping("/train/{trainId}/section/{sectionId}")
    public String section(@PathVariable int trainId, @PathVariable int sectionId){
        return simulation.sendTrainSection(trainId, sectionId);
    }
}
