package pl.pjatk.skmapi.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final int pauseCountOnEnd = 2;

    private List<Train> trains;
    private Station station = Station.STATION1;
    private int pause = pauseCountOnEnd;

    public Simulation(int x, int y, int z) {
        this.trains = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            List<Section> sections = new ArrayList<>();
            for (int j = 0; j < y; j++) {
                sections.add(new Section(z));
            }
            trains.add(new Train(sections));
        }
    }

    public String getJsonStringStatus() {
        ObjectMapper mapper = new ObjectMapper();
        String trainsAsJsonString;
        try {
            trainsAsJsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(trains);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            trainsAsJsonString = "Error";
        }
//        return "<pre>%s</pre>".formatted(trainsAsJsonString); //Debug
        return trainsAsJsonString;
    }

    private void nextStation() {
        if (station.isLast() && pause > 0) {
            pause--;
        } else {
            pause = pauseCountOnEnd;
            station = station.next();
        }
    }

    public void move() {
        System.out.println(station);
        nextStation();
    }
}
