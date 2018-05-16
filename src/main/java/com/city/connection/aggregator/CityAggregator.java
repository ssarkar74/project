package com.city.connection.aggregator;

import java.util.ArrayList;
import java.util.HashMap;

import com.city.connection.model.City;
import com.city.connection.model.Road;
import com.city.connection.model.RoadConnector;

public class CityAggregator {

	private HashMap<String, City> cityMapper = new HashMap<String, City>();
	private ArrayList<Road> roads = new ArrayList<Road>();
	private static int id = 0;
	
	public void addCity(String city) {
		City cityObject = new City(id, city);
		idIncrementor();
		cityMapper.put(city, cityObject);
	}
	
	public synchronized void idIncrementor() {
		 id++;
	}
	public City getCity(String city) {
		return cityMapper.get(city);
	}
	
	public int getNumberOfCities() {
		return this.cityMapper.size();
	}
	public void addRoad(Road road) {
		roads.add(road);
	}
	public boolean isConnected(String origin, String destination) {
		RoadConnector roads = new RoadConnector(this.getNumberOfCities());
		for (Road road : this.roads) {
			roads.addEdge(road.getOrigin(), road.getDestination());
		}
		roads.createMesh(this.getCity(origin));
		return roads.getConnected().contains(this.getCity(destination));
	}
}
