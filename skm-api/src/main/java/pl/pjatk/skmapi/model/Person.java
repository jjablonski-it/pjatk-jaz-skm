package pl.pjatk.skmapi.model;

import com.github.javafaker.Faker;
import pl.pjatk.skmapi.service.DbEntity;

import javax.persistence.*;

@Entity
@Table(name = "people")
public class Person implements DbEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    Station dest;

    @Column
    private String name;

    @Column
    private String lastname;

    public Person() {
    }

    public Person(Station dest) {
        Faker faker = new Faker();
        this.dest = dest;
        name = faker.name().firstName();
        lastname = faker.name().lastName();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
