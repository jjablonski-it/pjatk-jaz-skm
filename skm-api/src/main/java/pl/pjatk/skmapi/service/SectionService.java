package pl.pjatk.skmapi.service;

import org.springframework.stereotype.Service;
import pl.pjatk.skmapi.model.Section;
import pl.pjatk.skmapi.repository.CrudRepo;
import pl.pjatk.skmapi.repository.SectionRepository;

@Service
public class SectionService extends CrudService<Section> {
    public SectionService(SectionRepository sectionRepository, CrudRepo<Service> repository) {
        super(sectionRepository); }
}
