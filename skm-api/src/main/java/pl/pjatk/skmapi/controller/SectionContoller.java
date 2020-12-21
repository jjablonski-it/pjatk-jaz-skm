package pl.pjatk.skmapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.skmapi.model.Section;
import pl.pjatk.skmapi.service.CrudService;
import pl.pjatk.skmapi.service.SectionService;

@RestController
@RequestMapping("/section")
public class SectionContoller extends CrudController<Section> {
    protected SectionContoller(SectionService service) {
        super(service);
    }
}
