package pl.pjatk.skmapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjatk.skmapi.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
