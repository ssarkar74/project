package com.city.connection.util;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.city.connection.aggregator.CityAggregator;

public class FileProcessorTest {

	private static final String CITY_FILE = "city.txt";
	@Test
	public void testBuildRoads() throws IOException {
		CityAggregator aggregator = FileProcessor.buildRoads(CITY_FILE);
    	assertEquals(6, aggregator.getNumberOfCities());
	}
	
}
