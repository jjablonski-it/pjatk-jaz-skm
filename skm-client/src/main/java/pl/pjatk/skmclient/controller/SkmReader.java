package pl.pjatk.skmclient.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.pjatk.skmclient.model.Train;


@RestController
public class SkmReader {
    private final String URI = "http://skmapi:4000/train";
    private final RestTemplate template = new RestTemplate();

    @GetMapping
    public ResponseEntity getTrains() {
        return template.getForEntity(URI, Train[].class);
    }
}

