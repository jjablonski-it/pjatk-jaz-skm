package pl.pjatk.skmapi.model;

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

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public void nextStation() {
        boolean move = true;
        if ((station.isLast() || station.isFirst())) {
            if (pause == pauseCountOnEnd) forward = !forward;

            if (pause > 0) {
                pause--;
                move = false;
            } else {
                pause = pauseCountOnEnd;
            }
        }
        if (move)
            station = station.next(forward);
    }

    private List<Person> generatePeople() {
        List<Person> people = new ArrayList<>();
        int peopleCount = rand.nextInt(7) + 2;

        for (int i = 0; i < peopleCount; i++) {
            Station randStation = station.randNextStation(forward);
            if (randStation != null) {

                people.add(new Person(randStation));
            }
        }
        return people;
    }

    private Section getRandomFreeSection() {
        List<Section> localSections = new ArrayList<>(getSections());
        Section section = null;
        while (section == null) {
            int randIndex = rand.nextInt(localSections.size());
            Section tempSection = localSections.get(randIndex);

            if (tempSection.isFull()) localSections.remove(tempSection);
            else section = tempSection;
        }
        return section;
    }

    private void loadPeople() {
        List<Person> peopleWaiting = generatePeople();
        for (Person person : peopleWaiting) {
            if (isFull()) return;
            Section section = getRandomFreeSection();
            section.takeSeat(person);
        }
    }

    private void unloadPeople() {
        for (Section section : sections) {
            List<Person> peopleLeaving = new ArrayList<>();
            for (Person person : section.getPeople()) {
                if (person.dest == station) {
                    peopleLeaving.add(person);
                }
            }
            section.freeSeats(peopleLeaving);
        }
    }

    public void managePeople() {
        unloadPeople();
        loadPeople();
    }
}
