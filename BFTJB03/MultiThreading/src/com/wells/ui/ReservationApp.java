package com.wells.ui;

import com.wells.model.Flight;
import com.wells.service.ReservationService;

public class ReservationApp {

	public static void main(String[] args) {
		
		Flight f1 = new Flight(1, 25);
		//Flight f2 = new Flight(2, 25);
		//Flight f3 = new Flight(3, 25);
		
		ReservationService rs1=new ReservationService(f1, 10);
		ReservationService rs2=new ReservationService(f1, 10);
		ReservationService rs3=new ReservationService(f1, 10);

		Thread t1=new Thread(rs1);
		Thread t2=new Thread(rs2);
		Thread t3=new Thread(rs3);
		
		t1.start();
		t2.start();
		t3.start();
	}

}
