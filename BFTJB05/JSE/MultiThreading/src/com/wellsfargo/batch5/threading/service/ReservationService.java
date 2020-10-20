package com.wellsfargo.batch5.threading.service;

import java.util.ArrayList;
import java.util.List;

import com.wellsfargo.batch5.threading.model.Bus;

public class ReservationService implements Runnable {

	private int seatsNeeded;
	private Bus bus;
	private List<Integer> seatsReserved;

	public ReservationService(int seatsNeeded, Bus bus) {
		super();
		this.seatsNeeded = seatsNeeded;
		this.bus = bus;
		seatsReserved = new ArrayList<>();
	}

	private boolean isAvailable(int seatCount) {
		return bus.getMaxSeatCount()-bus.getLastSeatReserved()>=seatCount;
	}

	public void doReserve() {
		String tName = Thread.currentThread().getName();
		synchronized (bus) {
			if (!isAvailable(seatsNeeded )) {
				System.out.println(tName + ">> Sorry Could not reserve, Bus is full");
			} else {
				while (seatsNeeded > 0 && isAvailable(seatsNeeded )) {
					int availableSeat = bus.getLastSeatReserved() + 1;
					seatsReserved.add(availableSeat);
					seatsNeeded--;
					bus.setLastSeatReserved(availableSeat);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(tName + ">> Reserved Seats " + seatsReserved);
			}
		}
	}

	@Override
	public void run() {
		doReserve();
	}

}
