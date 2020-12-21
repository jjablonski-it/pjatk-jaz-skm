package pl.pjatk.skmapi.service;

import org.springframework.stereotype.Service;
import pl.pjatk.skmapi.exception.NotFoundException;
import pl.pjatk.skmapi.model.Section;
import pl.pjatk.skmapi.model.Train;
import pl.pjatk.skmapi.repository.TrainRepository;

@Service
public class TrainService extends CrudService<Train> {
    public TrainService(TrainRepository trainRepository) {
        super(trainRepository);
    }

    public void move() {
        for (Train train : repository.findAll()) {
            train.unloadPeople();
            train.loadPeople();
            train.nextStation();
        }
    }

    @Override
    public Train getUpdatedEntity(Train train) throws NotFoundException {
        var currentTrain = repository.findById(train.getId());
        if (currentTrain.isEmpty()) throw new NotFoundException();

        var currentTrainObj = currentTrain.get();
        currentTrainObj.setForward(train.isForward());
        currentTrainObj.setSections(train.getSections());
        currentTrainObj.setStation(train.getStation());
        return currentTrainObj;

    }
}
