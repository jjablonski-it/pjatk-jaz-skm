package pl.pjatk.skmapi.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class StationTest {
    @Test
    void station1ShouldBeFirst(){
        Assert.assertTrue(Station.STATION1.isFirst());
    }

    @Test
    void station10ShouldBeLast(){
        Assert.assertTrue(Station.STATION10.isLast());
    }

    @Test
    void nextShouldDependOnForward(){
        Station station = Station.STATION5;
        Assert.assertEquals(Station.STATION6, station.next(true));
        Assert.assertEquals(Station.STATION4, station.next(false));
    }

    @Test
    void nextRandomIndexShouldDependOnForward(){
        Station station = Station.STATION5;
        Assert.assertTrue(station.next(true).ordinal() > station.ordinal());
        Assert.assertTrue(station.next(false).ordinal() < station.ordinal());
    }

    @Test
    void randomShouldReturnStation(){
        Station station = Station.random();
        Assert.assertNotNull(station);
    }
}
