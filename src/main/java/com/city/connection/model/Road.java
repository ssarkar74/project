package com.city.connection.model;

public class Road {

	private City origin;
	private City destination;
	public City getOrigin() {
		return origin;
	}
	public void setOrigin(City origin) {
		this.origin = origin;
	}
	public City getDestination() {
		return destination;
	}
	public void setDestination(City destination) {
		this.destination = destination;
	}
	
	public void addCity(City city) {
		if(this.origin == null) {
			this.origin = city;
		} else if (this.destination == null) {
			this.destination = city;
		} else {
			throw new RuntimeException("Already origin and destination added");
		}
	}
}
