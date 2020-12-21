package pl.pjatk.skmapi.service;

import org.springframework.stereotype.Service;
import pl.pjatk.skmapi.model.Train;
import pl.pjatk.skmapi.repository.SectionRepository;
import pl.pjatk.skmapi.repository.TrainRepository;

@Service
public class SimulationService {
    private final SectionRepository sectionRepository;
    private final TrainRepository trainRepository;

    public SimulationService(TrainRepository trainRepository, SectionRepository sectionRepository) {
        this.trainRepository = trainRepository;
        this.sectionRepository = sectionRepository;
    }

    public void move(){
        for(Train train : trainRepository.findAll()){
            train.unloadPeople();
            train.loadPeople();
            train.nextStation();

            sectionRepository.saveAll(train.getSections());
            trainRepository.save(train);
        }
    }
}
