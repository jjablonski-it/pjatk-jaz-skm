package pl.pjatk.skmapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.pjatk.skmapi.model.Section;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {
}
