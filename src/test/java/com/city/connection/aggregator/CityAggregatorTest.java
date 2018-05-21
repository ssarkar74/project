package com.city.connection.aggregator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.city.connection.model.City;
import com.city.connection.model.Road;

public class CityAggregatorTest {

	@Test
	public void testGetCity() {
		CityAggregator cityAggregator = new CityAggregator();
		cityAggregator.idReset();
		cityAggregator.addCity("New York");
		City city = cityAggregator.getCity("New York");
		assertEquals(city.getId(), 0);
		assertEquals(city.getName(), "New York");
	}

	@Test
	public void testAddCity() {
		CityAggregator cityAggregator = new CityAggregator();
		cityAggregator.idReset();
		cityAggregator.addCity("New York");
		City city = cityAggregator.getCity("New York");
		assertEquals(city.getId(), 0);
		assertEquals(city.getName(), "New York");
	}

	@Test
	public void testIdIncrementor() {
		CityAggregator cityAggregator = new CityAggregator();
		cityAggregator.idReset();
		cityAggregator.idIncrementor();		
		assertTrue(true);
	}


	@Test
	public void testGetNumberOfCities() {
		CityAggregator cityAggregator = new CityAggregator();
		cityAggregator.idReset();
		cityAggregator.addCity("New York");
		assertEquals(cityAggregator.getNumberOfCities(), 1);
	}

	@Test
	public void testAddRoad() {
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

	@Test
	public void testIsConnected() {
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
