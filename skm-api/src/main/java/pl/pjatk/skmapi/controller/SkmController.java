package pl.pjatk.skmapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.skmapi.model.Simulation;


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

}
