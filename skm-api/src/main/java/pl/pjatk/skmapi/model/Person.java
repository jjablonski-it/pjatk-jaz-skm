package pl.pjatk.skmapi.model;

import com.github.javafaker.Faker;
import pl.pjatk.skmapi.service.DbEntity;
import java.util.Locale;

public class Person implements DbEntity {
    private long id;
    Station dest;
    private String name;
    private String lastname;

    public Person() {
    }

    public Person(Station dest) {
        Faker faker = new Faker(new Locale("pl-PL"));
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
