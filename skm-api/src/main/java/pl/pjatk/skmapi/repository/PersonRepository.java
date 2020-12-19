package pl.pjatk.skmapi.repository;

import org.springframework.stereotype.Repository;
import pl.pjatk.skmapi.model.Person;

@Repository
public interface PersonRepository extends CrudRepo<Person> {
}
