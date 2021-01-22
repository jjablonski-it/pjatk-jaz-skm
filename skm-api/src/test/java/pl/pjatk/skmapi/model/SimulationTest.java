package pl.pjatk.skmapi.model;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimulationTest {
	Simulation sim;

	@BeforeEach
	void setUp(){
		sim = Simulation.getInstance(2, 3, 4);
	}

	@Test
	void newSimulationWithXYZShouldCreateSimulationWithXTrainsYSectionsAndZSeats() {
		Assert.assertEquals(sim.getTrains().size(), 2);
		Assert.assertEquals(sim.getTrains().get(0).getSections().size(), 3);
		Assert.assertEquals(sim.getTrains().get(0).getSections().get(0).getMaxSeats(), 4);
	}
}
