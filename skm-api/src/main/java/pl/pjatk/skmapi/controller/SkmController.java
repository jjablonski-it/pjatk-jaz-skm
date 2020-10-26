package pl.pjatk.skmapi.controller;

import org.springframework.web.bind.annotation.*;
import pl.pjatk.skmapi.model.Simulation;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@RestController
public class SkmController {
    private Simulation simulation;

    public SkmController() {
        simulation = new Simulation(1, 1, 2);
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

    @GetMapping("/trains")
    public String trains(){
        return simulation.displayTrains();
    }

    @GetMapping("/train/{id}")
    public String train(@PathVariable int id){
        return simulation.displayTrain(id);
    }
}
