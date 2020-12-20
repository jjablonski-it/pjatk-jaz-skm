package pl.pjatk.skmapi.model;

import com.github.javafaker.Faker;
import pl.pjatk.skmapi.service.DbEntity;

import javax.persistence.Entity;
import java.util.Locale;

public class Person {
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


    public void setId(long id) {
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

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


}
