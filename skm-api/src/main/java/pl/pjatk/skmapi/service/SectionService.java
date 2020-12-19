package pl.pjatk.skmapi.service;

import org.springframework.stereotype.Service;
import pl.pjatk.skmapi.model.Section;
import pl.pjatk.skmapi.repository.SectionRepository;

@Service
public class SectionService extends CrudService<Section> {
    public SectionService(SectionRepository sectionRepository) {
        super(sectionRepository);
    }


//    public boolean takeSeat(Person person) {
//        if (people.size() < maxSeats) {
//            people.add(person);
//            return true;
//        }
//        return false;
//    }
//
//    public void freeSeats(List<Person> peopleLeaving) {
//        people.removeAll(peopleLeaving);
//    }
}
