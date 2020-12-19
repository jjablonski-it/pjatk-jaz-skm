package pl.pjatk.skmapi.service;

import org.springframework.stereotype.Service;
import pl.pjatk.skmapi.model.Person;
import pl.pjatk.skmapi.repository.PersonRepository;

@Service
public class PersonService extends CrudService<Person>{
    public PersonService(PersonRepository personRepository) {
        super(personRepository);
    }
}
