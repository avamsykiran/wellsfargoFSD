package com.wells.model;

public class Flight {

	private int seatCount;
	private int lastReservedSeat;
	
	public Flight(int seatCount) {
		this.lastReservedSeat=0;
		this.seatCount=seatCount;
	}

	public int getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}

	public int getLastReservedSeat() {
		return lastReservedSeat;
	}

	public void setLastReservedSeat(int lastReservedSeat) {
		this.lastReservedSeat = lastReservedSeat;
	}
	
	
}
