package pl.pjatk.skmapi.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import pl.pjatk.skmapi.exception.NotFoundException;
import pl.pjatk.skmapi.model.Section;
import pl.pjatk.skmapi.repository.SectionRepository;

@Service
public class SectionService extends CrudService<Section> {
    public SectionService(SectionRepository repository) {
        super(repository); }

    @Override
    public Section getUpdatedEntity(Section section) throws NotFoundException {
        var currentSection = repository.findById(section.getId());
        if(currentSection.isEmpty()) throw new NotFoundException();

        var currentSectionObj = currentSection.get();
        currentSectionObj.setTrain(section.getTrain());
        currentSectionObj.setPeople(section.getPeople());
        return currentSectionObj;
    }
}
