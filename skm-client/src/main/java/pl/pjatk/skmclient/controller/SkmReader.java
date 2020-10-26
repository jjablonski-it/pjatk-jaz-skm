package pl.pjatk.skmclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.pjatk.skmclient.model.Train;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class SkmReader {
    private final String URI = "http://skmapi:4000/";
    private final String trainURI = URI + "/train";
    private RestTemplate template = new RestTemplate();
    private String[] stations;
    private Train[] trains;

    public SkmReader() {
        stations = template.getForObject(URI + "/stations", String[].class);
//        trains = template.getForObject(URI, Train.class);
    }

    @GetMapping("/")
    public String status() {
        List<Integer> result = Arrays.asList(template.getForObject(trainURI, Integer[].class));
        StringBuilder builder = new StringBuilder("<h1>Trains</h1>");

        result.forEach(id -> {
            builder.append("<a href='/%d'>Train id: %d</a><br>".formatted(id, id));
        });

        return builder.toString();
    }

    @GetMapping("/{trainId}")
    public String train(@PathVariable("trainId") int trainId) {
        template.getForObject(URI+"/move", String.class);
        Train result = template.getForObject(trainURI + "/" + trainId, Train.class);
        List<Integer> sections = Arrays.asList(template.getForObject(trainURI + "/" + trainId + "/section", Integer[].class));
        StringBuilder builder = new StringBuilder("<h1>Train %d</h1>".formatted(trainId));
        StringBuilder mapBuilder = new StringBuilder("");

        System.out.println(result);
        for (String station : stations) {
            boolean current = result.getStation().equalsTo(station);
            mapBuilder.append("( <b>%s</b> ) - %s - ".formatted(current ? (result.isForward() ? ">" : "<") : " ", current ? "<b>%s</b>".formatted(station) : station));
        }
        mapBuilder.append("<br>");

        sections.forEach(sectionId -> {
            builder.append("<br><a href='/%d/section/%d'>Section id: %d</a>".formatted(trainId, sectionId, sectionId));
        });

        return mapBuilder.toString() + builder.toString();
    }

    @GetMapping("/{trainId}/section/{sectionId}")
    public String section(@PathVariable("trainId") int trainId, @PathVariable("sectionId") int sectionId) {
        String result = template.getForObject(trainURI + "/" + trainId + "/section/" + sectionId, String.class);

        return result;
    }

}

