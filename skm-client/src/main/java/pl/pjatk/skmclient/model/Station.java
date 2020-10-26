package pl.pjatk.skmclient.model;

public enum Station {
    STATION1,
    STATION2,
    STATION3,
    STATION4,
    STATION5,
    STATION6,
    STATION7,
    STATION8,
    STATION9,
    STATION10;
    public boolean equalsTo(String string){
        return this.name().equals(string);
    }
}
