package pl.pjatk.skmapi.repository;

import org.springframework.stereotype.Repository;
import pl.pjatk.skmapi.model.Train;

@Repository
public interface TrainRepository extends CrudRepo<Train> {
}
