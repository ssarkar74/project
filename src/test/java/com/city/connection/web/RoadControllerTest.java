package com.city.connection.web;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.city.connection.aggregator.CityAggregator;
import com.city.connection.util.FileProcessor;

public class RoadControllerTest {
	private static final String CITY_FILE = "city.txt";
	@Test
	public void testConnected() throws IOException {
		CityAggregator aggregator0 = FileProcessor.buildRoads(CITY_FILE);
    	assertTrue(aggregator0.isConnected("Trenton", "Albany"));
	}

	@Test
	public void testConnected2Way() throws IOException {
		CityAggregator aggregator0 = FileProcessor.buildRoads(CITY_FILE);
    	assertTrue(aggregator0.isConnected("Albany", "Trenton"));
	}

	@Test
	public void testInDirectConnected() throws IOException {
		CityAggregator aggregator0 = FileProcessor.buildRoads(CITY_FILE);
    	assertTrue(aggregator0.isConnected("Boston", "Philadelphia"));
	}
	
	@Test
	public void testNotConnected() throws IOException {
		CityAggregator aggregator0 = FileProcessor.buildRoads(CITY_FILE);
    	assertFalse(aggregator0.isConnected("Boston", "Edison"));
	}
	
	@Test
	public void testNotConnectedFromOtherCoutry() throws IOException {
		CityAggregator aggregator0 = FileProcessor.buildRoads(CITY_FILE);
    	assertFalse(aggregator0.isConnected("London", "Delhi"));
	}
}
