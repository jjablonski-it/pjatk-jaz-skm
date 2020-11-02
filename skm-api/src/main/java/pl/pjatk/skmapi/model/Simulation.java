package pl.pjatk.skmapi.model;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private List<Train> trains;

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

    public void move() {
        for (Train train : trains) {
            // Load people to trains
            train.managePeople();

            // Move all trains
            train.nextStation();
        }
    }

    public List<Integer> getTrainIds() {
        List<Integer> list = new ArrayList<>();
        trains.stream().forEach(train -> list.add(trains.indexOf(train)));
        return list;
    }

    public List<Integer> getSectionIds(int id) {
        List<Integer> list = new ArrayList<>();
        Train train = trains.get(id);
        train.getSections().stream().forEach(section -> list.add(train.getSections().indexOf(section)));
        return list;
    }

    public Section getTrainSection(int trainId, int sectionId) {
        Train train = trains.get(trainId);
        return train.getSections().get(sectionId);
    }
}
