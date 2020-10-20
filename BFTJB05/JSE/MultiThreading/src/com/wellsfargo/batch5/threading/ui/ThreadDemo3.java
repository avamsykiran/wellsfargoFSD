package com.wellsfargo.batch5.threading.ui;

import com.wellsfargo.batch5.threading.model.Bus;
import com.wellsfargo.batch5.threading.service.ReservationService;

public class ThreadDemo3 {

	public static void main(String[] args) {

		Bus bus = new Bus(25);
		
		ReservationService rs1 = new ReservationService(12, bus);
		ReservationService rs2 = new ReservationService(12, bus);
		ReservationService rs3 = new ReservationService(12, bus);
		
		Thread t1 = new Thread(rs1,"Vamsy");
		Thread t2 = new Thread(rs2,"Kiran");
		Thread t3 = new Thread(rs3,"Srinu");
		
		t1.start();
		t2.start();
		t3.start();
	}

}
