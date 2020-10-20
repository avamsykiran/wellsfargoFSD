package com.wellsfargo.batch7.threading.model;

public class Flight {

	private int maxSeats;
	private int lastReservedSeat;

	public Flight(int maxSeats) {
		this.maxSeats = maxSeats;
		this.lastReservedSeat = 0;
	}

	public int getMaxSeats() {
		return maxSeats;
	}

	public void setMaxSeats(int maxSeats) {
		this.maxSeats = maxSeats;
	}

	public int getLastReservedSeat() {
		return lastReservedSeat;
	}

	public void setLastReservedSeat(int lastReservedSeat) {
		this.lastReservedSeat = lastReservedSeat;
	}

}
