package com.city.connection.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

import com.city.connection.aggregator.CityAggregator;
import com.city.connection.model.Road;

public class FileProcessor {

	private static CityAggregator aggregator; 
	public static CityAggregator buildRoads(String fileName) throws IOException {
		if(aggregator != null) {
			return aggregator;
		}
		aggregator = new CityAggregator();
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		HashSet<String> citySet = new HashSet<String>();
		String recordLine;
		while ((recordLine = reader.readLine()) != null) {
			String[] cities = recordLine.split(",", 0);
			Road road = new Road();
			for (String city : cities) {
				city = city.trim();
				city = city.toUpperCase();
				if(citySet.add(city)) {
					aggregator.addCity(city);
				}
				road.addCity(aggregator.getCity(city));				
			}
			aggregator.addRoad(road);
		}
		return aggregator;
	}
}
