package pl.pjatk.skmapi.service;

import org.springframework.stereotype.Service;
import pl.pjatk.skmapi.model.Train;
import pl.pjatk.skmapi.repository.TrainRepository;

@Service
public class TrainService extends CrudService<Train> {
    public TrainService(TrainRepository trainRepository) {
        super(trainRepository);
    }

    public void move(){
        for(Train train : repository.findAll()){
            train.unloadPeople();
            train.loadPeople();
            train.nextStation();
        }
    }
}
