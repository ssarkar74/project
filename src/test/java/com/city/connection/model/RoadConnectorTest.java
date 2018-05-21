package com.city.connection.model;

import static org.junit.Assert.*;

import org.junit.Test;

import com.city.connection.aggregator.CityAggregator;

public class RoadConnectorTest {

	@Test
	public void testRoadConnector() {
		RoadConnector roadConnector = new RoadConnector(0);
		assertEquals(0, roadConnector.getConnected().size());
	}

	@Test
	public void testGetConnected() {
		RoadConnector roadConnector = new RoadConnector(0);
		assertEquals(0, roadConnector.getConnected().size());
	}


	@Test
	public void testAddEdge() {
		CityAggregator cityAggregator = new CityAggregator();
		cityAggregator.idReset();
		Road road = new Road();
		final String ORIGIN = "NEW YORK";
		final String DESTINITION = "BOSTON";
		cityAggregator.addCity(ORIGIN);
		cityAggregator.addCity(DESTINITION);
		
		road.addCity(cityAggregator.getCity(ORIGIN));
		road.addCity(cityAggregator.getCity(DESTINITION));
		cityAggregator.addRoad(road);
		
		boolean connected = cityAggregator.isConnected(ORIGIN, DESTINITION);
		assertTrue(connected);
	}

}
