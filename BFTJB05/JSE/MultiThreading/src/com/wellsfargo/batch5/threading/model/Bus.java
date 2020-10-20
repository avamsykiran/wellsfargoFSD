package com.wellsfargo.batch5.threading.model;

public class Bus {
	
	private int maxSeatCount;
	private int lastSeatReserved;
	
	public Bus(int maxSeatCount) {
		super();
		this.maxSeatCount = maxSeatCount;
		this.lastSeatReserved = 0;
	}

	public int getMaxSeatCount() {
		return maxSeatCount;
	}

	public void setMaxSeatCount(int maxSeatCount) {
		this.maxSeatCount = maxSeatCount;
	}

	public int getLastSeatReserved() {
		return lastSeatReserved;
	}

	public void setLastSeatReserved(int lastSeatReserved) {
		this.lastSeatReserved = lastSeatReserved;
	}
	
	

}
