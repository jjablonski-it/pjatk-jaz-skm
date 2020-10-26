package pl.pjatk.skmapi.model;

import com.github.javafaker.Faker;

import java.util.Random;

public class Person {
    Station dest;
    private String name;
    private String lastname;

    public Person(Station dest) {
        Faker faker = new Faker();
        this.dest = dest;
        name = faker.name().firstName();
        lastname = faker.name().lastName();
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
