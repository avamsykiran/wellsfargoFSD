package com.wells.ui;

import com.wells.model.Bus;
import com.wells.service.ReservationService;

public class ReservationApp {

	public static void main(String[] args) {
		
		Bus bus = new Bus(25);
		
		ReservationService rs1 = new ReservationService(bus, 10);
		ReservationService rs2 = new ReservationService(bus, 10);
		ReservationService rs3 = new ReservationService(bus, 10);

		Thread t1= new Thread(rs1);
		Thread t2= new Thread(rs2);
		Thread t3= new Thread(rs3);
		
		System.out.println("Reservtion statred...");
		
		t1.start();
		t2.start();
		t3.start();
	}

}
