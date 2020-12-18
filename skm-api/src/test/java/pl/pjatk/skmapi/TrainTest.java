package pl.pjatk.skmapi;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pl.pjatk.skmapi.model.Person;
import pl.pjatk.skmapi.model.Section;
import pl.pjatk.skmapi.model.Station;
import pl.pjatk.skmapi.model.Train;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootTest
public class TrainTest {
    Train train;

    @BeforeEach
    void setUp(){
        int sectionsCount = 2;
        int seats = 5;
        var sections = IntStream.range(0,sectionsCount).mapToObj(value -> new Section(seats)).collect(Collectors.toList());
        train = new Train(sections, sectionsCount*seats);
    }

    @Test
    void traninShouldHave2Sections5SeatsEachAndHavePropertiesSet(){
        Assert.assertNotNull(train);
        Assert.assertEquals(2, train.getSections().size());
        Assert.assertEquals(5 ,train.getSections().get(0).getMaxSeats());
        Assert.assertEquals(0, train.getPeopleCount());
        Assert.assertNotNull(train.getStation());
        Assert.assertNotNull(train.isForward());
    }

    @Test
    void trainLoadPeopleShouldLoadBetween2And8People(){
        train.loadPeople();
        Assert.assertTrue(train.getPeopleCount()>=2 && train.getPeopleCount()<8);
    }

    @Test
    void onlyPeopleAtTheirDestinationShouldLeaveTheTrain(){
        // Same station
        train.getSections().get(0).takeSeat(new Person(train.getStation()));
        // Different station
        train.getSections().get(1).takeSeat(new Person(train.getStation().next(train.isForward())));

        Assert.assertEquals(2, train.getPeopleCount());
        train.unloadPeople();
        Assert.assertEquals(1, train.getPeopleCount());
    }

    @Test
    void nextStationShouldChangeTrainsStationDependingOnForward(){
        Station currentStation = train.getStation();
        train.nextStation();
        Assert.assertEquals(currentStation.next(train.isForward()), train.getStation());
    }
}
