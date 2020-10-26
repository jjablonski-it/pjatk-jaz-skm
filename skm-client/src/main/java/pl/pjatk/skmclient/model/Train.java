package pl.pjatk.skmclient.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Train {
    private final int pauseCountOnEnd = 2;
    private int pause = pauseCountOnEnd;

    private boolean forward;
    private List<Section> sections;
    private Station station;
    private Random rand = new Random();
    private int size;

    public Train(List<Section> sections, int size) {
        this.size = size;
        this.sections = sections;
        this.station = Station.random();
        this.forward = rand.nextBoolean();
    }

    public boolean isFull() {
        for (Section section : sections) {
            if (!section.isFull()) return false;
        }
        return true;
    }

    public int getPeopleCount() {
        int count = 0;
        for (Section section : sections) {
            for (Person person : section.getPeople()) {
                count++;
            }
        }
        return count;
    }

    public double getTakenPercent() {
        return (1.0 * getPeopleCount() / size) * 100.0;
    }

    public boolean isForward() {
        return forward;
    }

    public Station getStation() {
        return station;
    }

   
}
