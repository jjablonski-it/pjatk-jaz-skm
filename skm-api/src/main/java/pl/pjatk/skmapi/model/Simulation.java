package pl.pjatk.skmapi.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Simulation {

    private List<Train> trains;
    private Station station = Station.STATION1;

    Random rand = new Random();

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
            trainsAsJsonString = e.getMessage();
        }
        return "<pre>%s</pre>".formatted(trainsAsJsonString); //Debug
//        return trainsAsJsonString;
    }

    public void moveTrains() {
        for (Train train : trains) {
            train.nextStation();
        }
    }

    public void move() {
        for(Train train: trains){
            // Load people to trains
            train.managePeople();

            // Move all trains
            train.nextStation();
        }
    }
}
