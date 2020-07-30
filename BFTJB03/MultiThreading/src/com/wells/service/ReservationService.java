package com.wells.service;

import java.util.ArrayList;
import java.util.List;

import com.wells.model.Flight;

public class ReservationService implements Runnable {

	private Flight flight;
	private int requiredSeats;
	private List<Integer> seatsReserved;

	public ReservationService(Flight flight, int requiredSeats) {
		this.flight = flight;
		this.requiredSeats = requiredSeats;
		this.seatsReserved = new ArrayList<>();
	}

	private boolean isFlightFull() {
		return flight.getLastAlloted() == flight.getMaxSeats();
	}

	private int availableSeats() {
		return flight.getMaxSeats() - flight.getLastAlloted();
	}

	public void reserve() throws InterruptedException {

		Thread t = Thread.currentThread();
		String tName = t.getName();

		if (isFlightFull()) {
			System.out.println(tName + ">> Sorry Flight is full!");
		} else if (availableSeats() < requiredSeats) {
			System.out.println(tName + ">> Sorry Not Enough Seats!");
		} else {
			synchronized (this.flight) {
				while (requiredSeats > 0) {
					if (availableSeats() >= requiredSeats) {
						int seatToBeReserved = flight.getLastAlloted() + 1;
						seatsReserved.add(seatToBeReserved);
						flight.setLastAlloted(seatToBeReserved);
						requiredSeats--;
						System.out.println(tName + "Reserved Seat#" + seatToBeReserved);
						Thread.sleep(1000);
					} else {
						break;
					}
				}
			}
		}

		System.out.println(tName + ">>Flight# " + flight.getFlightCode() + " Seats Alloted: " + seatsReserved);
	}

	@Override
	public void run() {
		try {
			reserve();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
