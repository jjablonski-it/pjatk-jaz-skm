package pl.pjatk.skmapi.service;

import org.springframework.stereotype.Service;
import pl.pjatk.skmapi.model.Person;
import pl.pjatk.skmapi.model.Section;
import pl.pjatk.skmapi.model.Train;
import pl.pjatk.skmapi.repository.PersonRepository;
import pl.pjatk.skmapi.repository.SectionRepository;
import pl.pjatk.skmapi.repository.TrainRepository;

@Service
public class SimulationService {
    private SectionRepository sectionRepository;
    private TrainRepository trainRepository;
    private PersonRepository personRepository;

    public SimulationService(TrainRepository trainRepository, SectionRepository sectionRepository, PersonRepository personRepository) {
        this.trainRepository = trainRepository;
        this.sectionRepository = sectionRepository;
        this.personRepository = personRepository;
    }

    public void move() {
        for (Train train : trainRepository.findAll()) {
            train.unloadPeople();
            train.loadPeople();
            train.nextStation();

            for (Section section : train.getSections()) {
                personRepository.saveAll(section.getPeople());
            }

            sectionRepository.saveAll(train.getSections());
            trainRepository.save(train);
        }
    }
}
