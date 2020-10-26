package pl.pjatk.skmapi.model;

import java.util.Random;

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
    private static Station[] vals = values();
    private static Random rand = new Random();

    public static Station first() {
        return vals[0];
    }

    public boolean isLast() {
        return this.ordinal() == (vals.length - 1);
    }

    public boolean isFirst() {
        return this.ordinal() == 0;
    }

    public Station next(boolean forward) {
        if (!forward) {
            int index = this.ordinal() - 1;
            if (index < 0) index = vals.length - 1;
            return vals[index];
        }
        return vals[(this.ordinal() + 1) % vals.length];
    }

    public Station randNextStation(boolean forward) {
        int min;
        int max;

        if ((isFirst() && !forward) || (isLast() && forward)){
            return null;
        }

        if (forward) {
            min = this.ordinal() + 1;
            max = vals.length - 1;
        } else {
            min = 0;
            max = this.ordinal() - 1;
        }

        int index = rand.nextInt((max - min) + 1) + min;
        return vals[index];
    }

    public static Station random() {
        return vals[rand.nextInt(vals.length-2)+1];
    }
}
