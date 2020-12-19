package pl.pjatk.skmapi.model;

import pl.pjatk.skmapi.service.DbEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sections")
public class Section implements DbEntity {
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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


    public boolean isFull() {
        return people.size() == maxSeats;
    }
}
