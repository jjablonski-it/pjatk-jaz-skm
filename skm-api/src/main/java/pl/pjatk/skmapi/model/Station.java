package pl.pjatk.skmapi.model;

public enum Station {
    STATION1,
    STATION2,
    STATION3,
    STATION4,
    STATION5;
    private static Station[] vals = values();

    public boolean isLast() {
        return this.ordinal() == (vals.length - 1);
    }

    public Station next() {
        return vals[(this.ordinal() + 1) % vals.length];
    }
}
