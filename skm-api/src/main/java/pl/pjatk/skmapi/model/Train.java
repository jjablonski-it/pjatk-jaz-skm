package pl.pjatk.skmapi.model;

import java.io.Serializable;
import java.util.List;

public class Train {
    List<Section> sections;

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public Train(List<Section> sections) {
        this.sections = sections;
    }
}
