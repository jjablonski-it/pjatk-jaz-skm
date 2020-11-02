package pl.pjatk.skmclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.pjatk.skmclient.model.Section;
import pl.pjatk.skmclient.model.Station;
import pl.pjatk.skmclient.model.Train;

import java.util.Arrays;
import java.util.List;

@RestController
public class SkmReader {
    private final String URI = "http://skmapi:4000";
    private final String trainURI = URI + "/train";
    private RestTemplate template = new RestTemplate();
    private Station[] stations = Station.values();

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
        template.getForObject(URI + "/move", String.class);
        Train train = template.getForObject(trainURI + "/" + trainId, Train.class);
        List<Integer> sections = Arrays.asList(template.getForObject(trainURI + "/" + trainId + "/section", Integer[].class));

        StringBuilder builder = new StringBuilder("<h1>Train %d</h1>".formatted(trainId));
        StringBuilder mapBuilder = new StringBuilder("");

        if (stations != null)
            for (Station station : stations) {
                boolean current = train.getStation() == station;
                mapBuilder.append("( <b>%s</b> ) - %s - ".formatted(current ? (train.isForward() ? ">" : "<") : " ", current ? "<b>%s</b>".formatted(station) : station));
            }
        mapBuilder.append("<br>");

        sections.forEach(sectionId -> {
            builder.append("<br><a href='/%d/section/%d'>Section id: %d</a>".formatted(trainId, sectionId, sectionId));
        });

        String nextButton = "<br><a href='/%d'><button>Next station</button></a>".formatted(trainId);
        String percentage = "Taken percent: " + train.getTakenPercent() + "%";

        return mapBuilder.toString() + nextButton + percentage + builder.toString();
    }

    @GetMapping("/{trainId}/section/{sectionId}")
    public Section section(@PathVariable("trainId") int trainId, @PathVariable("sectionId") int sectionId) {
        Section result = template.getForObject(trainURI + "/" + trainId + "/section/" + sectionId, Section.class);

        return result;
    }

}

