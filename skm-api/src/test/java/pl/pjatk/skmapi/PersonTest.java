package pl.pjatk.skmapi;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import pl.pjatk.skmapi.model.Person;
import pl.pjatk.skmapi.model.Station;

public class PersonTest {
    @Test
    void twoPeopleShouldHaveDifferentNames(){
        Person p1 = new Person(Station.random());
        Person p2 = new Person(Station.random());
        Assert.assertNotEquals(p1.getName(), p2.getName());
        Assert.assertNotEquals(p1.getLastname(), p2.getLastname());
    }
}
