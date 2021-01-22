package pl.pjatk.skmapi.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class PersonTest {
    @Test
    void twoPeopleShouldHaveDifferentNames(){ // i know it's stupid
        Person p1 = new Person(Station.random());
        Person p2 = new Person(Station.random());
        Assert.assertNotEquals(p1.getName(), p2.getName());
        Assert.assertNotEquals(p1.getLastname(), p2.getLastname());
    }
}
