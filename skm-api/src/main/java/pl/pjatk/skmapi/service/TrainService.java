package pl.pjatk.skmapi.service;

import org.springframework.stereotype.Service;
import pl.pjatk.skmapi.model.Train;
import pl.pjatk.skmapi.repository.CrudRepo;
import pl.pjatk.skmapi.repository.TrainRepository;

@Service
public class TrainService extends CrudService<Train> {
    public TrainService(TrainRepository trainRepository) {
        super(trainRepository);
    }

//    public void move() {
//        for (Train train : trains) {
//            // Load people to trains
//            train.unloadPeople();
//            train.loadPeople();
//
//            // Move all trains
//            train.nextStation();
//        }
//    }
//
//    public void nextStation() {
//        boolean move = true;
//        if ((station.isLast() || station.isFirst())) {
//            if (pause == pauseCountOnEnd) forward = !forward;
//
//            if (pause > 0) {
//                pause--;
//                move = false;
//            } else {
//                pause = pauseCountOnEnd;
//            }
//        }
//        if (move)
//            station = station.next(forward);
//    }
//
//    private List<Person> generatePeople() {
//        List<Person> people = new ArrayList<>();
//        int peopleCount = rand.nextInt(7) + 2;
//
//        for (int i = 0; i < peopleCount; i++) {
//            Station randStation = station.randNextStation(forward);
//            if (randStation != null) {
//
//                people.add(new Person(randStation));
//            }
//        }
//        return people;
//    }
//
//    private Section getRandomFreeSection() {
//        List<Section> localSections = new ArrayList<>(getSections());
//        Section section = null;
//        while (section == null) {
//            int randIndex = rand.nextInt(localSections.size());
//            Section tempSection = localSections.get(randIndex);
//
//            if (tempSection.isFull()) localSections.remove(tempSection);
//            else section = tempSection;
//        }
//        return section;
//    }
//
//    public void loadPeople() {
//        List<Person> peopleWaiting = generatePeople();
//        for (Person person : peopleWaiting) {
//            if (isFull()) return;
//            Section section = getRandomFreeSection();
//            section.takeSeat(person);
//        }
//    }
//
//    public void unloadPeople() {
//        for (Section section : sections) {
//            List<Person> peopleLeaving = new ArrayList<>();
//            for (Person person : section.getPeople()) {
//                if (person.dest == station) {
//                    peopleLeaving.add(person);
//                }
//            }
//            section.freeSeats(peopleLeaving);
//        }
//    }
}
