package pl.pjatk.skmclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SkmReader {
    private final String URI = "http://skmapi:4000/train/0";

    @GetMapping("/")
    public String status() {
        RestTemplate template = new RestTemplate();
        String result = template.getForObject(URI, String.class);
        return "<pre>%s</pre>".formatted(result);
    }
}
