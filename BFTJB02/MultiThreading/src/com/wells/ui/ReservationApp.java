package com.wells.ui;

import com.wells.model.Flight;
import com.wells.service.ReservationService;

public class ReservationApp {
	public static void main(String args[]) {

		Flight f1 = new Flight(30);
		Flight f2 = new Flight(20);

		ReservationService rs1 = new ReservationService(f1, 10);
		ReservationService rs2 = new ReservationService(f2, 10);

		/*
		 * try { rs1.reserve(); rs2.reserve(); } catch (InterruptedException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }
		 */

		Thread t1 = new Thread(rs1);
		Thread t2 = new Thread(rs2);

		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Jobs Done");

	}
}
