package pl.pjatk.skmclient.model;

public class Person {
    Station dest;
    private String name;
    private String lastname;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public Station getDest() {
        return dest;
    }
}
