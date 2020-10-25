package pl.pjatk.skmapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.skmapi.model.Section;
import pl.pjatk.skmapi.model.Train;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class SkmController {
    private int x = 10;
    private int y = 4;
    private int z = 20;
    private List<Train> trains;

    public SkmController() {
        this.trains = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            List<Section> sections = new ArrayList<>();
            for (int j = 0; j < y; j++) {
                sections.add(new Section(z));
            }
            trains.add(new Train(sections));
        }
    }

    @GetMapping("/status")
    public String getStatus() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String trainsAsJsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(trains);
//        return "<pre>%s</pre>".formatted(trainsAsJsonString); //Debug
        return trainsAsJsonString;
    }
}
