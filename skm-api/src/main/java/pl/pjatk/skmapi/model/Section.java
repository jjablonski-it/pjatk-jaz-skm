package pl.pjatk.skmapi.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sections")
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int maxSeats;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Person> people;

    public int getMaxSeats() {
        return maxSeats;
    }

    public int getSeatsTaken() {
        return people.size();
    }

    public double getTakenPercent() {
        return 1.0 * getSeatsTaken() / maxSeats * 100.0;
    }

    public Section() {
    }

    public Section(int maxSeats) {
        people = new ArrayList<>();
        this.maxSeats = maxSeats;
    }

    public List<Person> getPeople() {
        return people;
    }

    public boolean takeSeat(Person person) {
        if (people.size() < maxSeats) {
            people.add(person);
            return true;
        }
        return false;
    }

    public void freeSeats(List<Person> peopleLeaving) {
        people.removeAll(peopleLeaving);
    }

    public boolean isFull() {
        return people.size() == maxSeats;
    }
}
