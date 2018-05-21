package com.city.connection.aggregator;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.city.connection.model.City;
import com.city.connection.model.Road;
import com.city.connection.model.RoadConnector;

@Service("cityAggregator")
public class CityAggregator {

	private HashMap<String, City> cityMapper = new HashMap<String, City>();
	private ArrayList<Road> roads = new ArrayList<Road>();
	private static int id = 0;
	
	

	public CityAggregator() {
		super();
	}

	public void addCity(String city) {
		if(!cityMapper.containsKey(city)) {
			City cityObject = new City(id, city);
			idIncrementor();
			cityMapper.put(city, cityObject);
		}
	}
	
	public synchronized void idIncrementor() {
		 id++;
	}
	
	public synchronized void idReset() {
		 id = 0 ;
	}
	
	public City getCity(String city) {
		return cityMapper.get(city);
	}
	
	public int getNumberOfCities() {
		return this.cityMapper.size();
	}
	public void addRoad(Road road) {
		if (!this.cityMapper.containsKey(road.getOrigin().getName())){
			this.addCity(road.getOrigin().getName());
		}  
		if(!this.cityMapper.containsKey(road.getDestination().getName())) {
			this.addCity(road.getDestination().getName());
		}
		roads.add(road);
	}
	public boolean isConnected(String origin, String destination) {
		if(origin != null) {
			origin = origin.toUpperCase();
		}
		if(destination != null) {
			destination = destination.toUpperCase();
		}
		RoadConnector roads = new RoadConnector(this.getNumberOfCities());
		for (Road road : this.roads) {
			roads.addEdge(road.getOrigin(), road.getDestination());
		}
		roads.createMesh(this.getCity(origin));
		return roads.getConnected().contains(this.getCity(destination));
	}
}
