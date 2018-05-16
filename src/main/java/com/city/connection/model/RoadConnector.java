package com.city.connection.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class RoadConnector {

	private int numberOfCities;
	private LinkedList<City> edge[];
	private HashSet<City> connected;
	
	public HashSet<City> getConnected() {
		return connected;
	}

	public void setConnected(HashSet<City> connected) {
		this.connected = connected;
	}

	public RoadConnector(int numberOfCities) {
		this.numberOfCities = numberOfCities;
		this.edge = new LinkedList[numberOfCities];
		for (int i = 0; i < numberOfCities; i++) {
			this.edge[i] = new LinkedList<City>();
		}
		connected = new HashSet<City>();
	}
	
	public void addEdge(City origin, City destination) {
		this.edge[origin.getId()].add(destination);
		this.edge[destination.getId()].add(origin);
	}
	
	public void meshBuilder(City origin, boolean visited[]) {
		if(origin == null) {
			return;
		}
		visited[origin.getId()] = true;		
		connected.add(origin);
		Iterator<City> cities  = this.edge[origin.getId()].listIterator();
        while (cities.hasNext()) {
            City city = cities.next();
            if (!visited[city.getId()])
                meshBuilder(city, visited);
        } 
	}
	
	public void createMesh(City origin) {
        boolean visited[] = new boolean[numberOfCities];
        meshBuilder(origin, visited);
    }
}
