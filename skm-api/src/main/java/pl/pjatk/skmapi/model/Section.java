package pl.pjatk.skmapi.model;

import java.io.Serializable;

public class Section {
    int freeSpaces;

    public int getFreeSpaces() {
        return freeSpaces;
    }

    public void setFreeSpaces(int freeSpaces) {
        this.freeSpaces = freeSpaces;
    }

    public Section(int freeSpaces) {
        this.freeSpaces = freeSpaces;
    }
}
