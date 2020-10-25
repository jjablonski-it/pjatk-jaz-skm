package pl.pjatk.skmapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.skmapi.model.Section;
import pl.pjatk.skmapi.model.Simulation;
import pl.pjatk.skmapi.model.Train;

import java.beans.SimpleBeanInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class SkmController {
    private Simulation simulation;

    public SkmController() {
        simulation = new Simulation(1, 2, 3);
    }

    @GetMapping("/status")
    public String getStatus() {
        return simulation.getJsonStringStatus();
    }

    @GetMapping("/move")
    public void move() {
        simulation.move();
    }

}
