package com.wells.service;

import java.util.ArrayList;
import java.util.List;

import com.wells.model.Bus;

public class ReservationService implements Runnable {

	private Bus bus;
	private int requiredSeatCount;
	private List<Integer> reservedSeats;

	public ReservationService(Bus bus, int requiredSeatCount) {
		this.bus = bus;
		this.requiredSeatCount = requiredSeatCount;
		this.reservedSeats = new ArrayList<>();
	}

	public void reserve() throws InterruptedException {		
		if (bus.getSeatCount() >= requiredSeatCount) {
			synchronized (bus) {
				while (requiredSeatCount > 0) {
					if (bus.getSeatCount() >= requiredSeatCount) {
						int availableSeat = bus.getSeatCount();
						reservedSeats.add(availableSeat);
						requiredSeatCount--;
						bus.setSeatCount(bus.getSeatCount() - 1);
					}else {
						break;
					}
					Thread.sleep(200);
				}	
			}
		}else {
			System.out.println(Thread.currentThread().getName() + ">> Sorry no seats available");
		}
	}

	@Override
	public void run() {
		try {
			reserve();

			System.out.println(Thread.currentThread().getName() + ">> " + reservedSeats);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
