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

    @Override
    public String toString() {
        return "Train{" +
                "pauseCountOnEnd=" + pauseCountOnEnd +
                ", pause=" + pause +
                ", forward=" + forward +
                ", sections=" + sections +
                ", station=" + station +
                ", size=" + size +
                '}';
    }

    public int getPauseCountOnEnd() {
        return pauseCountOnEnd;
    }

    public int getPause() {
        return pause;
    }

    public void setPause(int pause) {
        this.pause = pause;
    }

    public void setForward(boolean forward) {
        this.forward = forward;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Random getRand() {
        return rand;
    }

    public void setRand(Random rand) {
        this.rand = rand;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Train() {
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

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

}
