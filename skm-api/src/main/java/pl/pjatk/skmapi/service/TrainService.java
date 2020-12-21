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

    @Override
    public Train getUpdatedEntity(Train train) throws NotFoundException {
        var currentTrain = repository.findById(train.getId());
        if (currentTrain.isEmpty()) throw new NotFoundException();

        var currentTrainObj = currentTrain.get();

        if ((Boolean) train.isForward() != null)
            currentTrainObj.setForward(train.isForward());
        if (train.getSections() != null)
            currentTrainObj.setSections(train.getSections());
        if (train.getStation() != null)
            currentTrainObj.setStation(train.getStation());
        return currentTrainObj;

    }
}
