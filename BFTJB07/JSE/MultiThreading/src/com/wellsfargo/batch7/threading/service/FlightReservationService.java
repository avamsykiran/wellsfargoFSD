package com.wellsfargo.batch7.threading.service;

import java.util.ArrayList;
import java.util.List;

import com.wellsfargo.batch7.threading.model.Flight;

public class FlightReservationService implements Runnable {

	private Flight flight;
	private int seatsRequired;
	private List<Integer> seatsReserved;

	public FlightReservationService(Flight flight, int seatsRequired) {
		super();
		this.flight = flight;
		this.seatsRequired = seatsRequired;
		this.seatsReserved = new ArrayList<>();
	}

	public boolean isAvailable(int seatsRequired) {
		return (flight.getMaxSeats() - flight.getLastReservedSeat()) >= seatsRequired;
	}

	public void doReserve() {
		String tName = Thread.currentThread().getName();
		
		synchronized (flight) {
			if (!isAvailable(seatsRequired)) {
				System.out.println(tName + ":: Sorry! Not Enough Seats");
			} else {
				while (seatsRequired > 0 && isAvailable(seatsRequired)) {
					int seatToBeReserved = flight.getLastReservedSeat() + 1;
					seatsReserved.add(seatToBeReserved);
					flight.setLastReservedSeat(seatToBeReserved);
					seatsRequired--;
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(tName + ":: ReservedSeats " + seatsReserved);
			}
		}
	}

	@Override
	public void run() {
		doReserve();
	}
}
