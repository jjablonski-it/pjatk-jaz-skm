package pl.pjatk.skmapi.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Simulation {
    private List<Train> trains;
    Random rand = new Random();

    public List<Train> getTrains() {
        return trains;
    }

    public Simulation(int x, int y, int z) {
        this.trains = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            List<Section> sections = new ArrayList<>();
            for (int j = 0; j < y; j++) {
                sections.add(new Section(z));
            }
            trains.add(new Train(sections, y*z));
        }
    }

    private String toJson(Object O) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(O);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public String getJsonStringStatus() {
        return toJson(trains);
    }

    public void move() {
        for (Train train : trains) {
            // Load people to trains
            train.managePeople();

            // Move all trains
            train.nextStation();
        }
    }

    public Train sendTrain(@PathVariable int id) {
        try {
            return trains.get(id);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public List<Object> sendSections(int trainId) {
        List<Object> list = new ArrayList<>();
        Train train = null;
        try {
            train = trains.get(trainId);
        } catch (Exception e) {
            return null;
        }
        Train finalTrain = train;
        train.getSections().stream().forEach(section -> list.add(finalTrain.getSections().indexOf(section)));
        return list;
    }

    public String sendTrainSection(int trainId, int sectionId) {
        try {
            Train train = trains.get(trainId);
            return toJson(train.getSections().get(sectionId));
        } catch (IndexOutOfBoundsException e) {
            return toJson("Not found");
        }
    }

    public List<Object> getTrainIds() {
        List<Object> list = new ArrayList<>();
        trains.stream().forEach(train -> list.add(trains.indexOf(train)));
        return list;
    }
}
