package pl.pjatk.skmclient.model;

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
    private int peopleCount;
    private double takenPercent;
    private boolean isFull;

    public Train() {

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

    public boolean isForward() {
        return forward;
    }

    public void setForward(boolean forward) {
        this.forward = forward;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public Station getStation() {
        return station;
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

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public double getTakenPercent() {
        return takenPercent;
    }

    public void setTakenPercent(double takenPercent) {
        this.takenPercent = takenPercent;
    }

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }
}
