package com.wells.model;

public class Flight {
	
	private int flightCode;
	private int maxSeats;
	private int lastAlloted;
	
	public Flight(int flightCode,int maxSeats) {
		this.flightCode=flightCode;
		this.maxSeats=maxSeats;
		this.lastAlloted=0;
	}

	public int getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(int flightCode) {
		this.flightCode = flightCode;
	}

	public int getMaxSeats() {
		return maxSeats;
	}

	public void setMaxSeats(int maxSeats) {
		this.maxSeats = maxSeats;
	}

	public int getLastAlloted() {
		return lastAlloted;
	}

	public void setLastAlloted(int lastAlloted) {
		this.lastAlloted = lastAlloted;
	}

}
