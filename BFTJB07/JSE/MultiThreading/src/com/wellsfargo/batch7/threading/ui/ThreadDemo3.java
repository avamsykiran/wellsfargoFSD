package com.wellsfargo.batch7.threading.ui;

import com.wellsfargo.batch7.threading.model.Flight;
import com.wellsfargo.batch7.threading.service.FlightReservationService;

public class ThreadDemo3 {

	public static void main(String[] args) {
		
		Flight f = new Flight(25);
		
		FlightReservationService frs1 = new FlightReservationService(f, 12);
		FlightReservationService frs2 = new FlightReservationService(f, 12);
		FlightReservationService frs3 = new FlightReservationService(f, 12);
		
		Thread t1 = new Thread(frs1,"Vamsy");
		Thread t2 = new Thread(frs2,"Sagar");
		Thread t3 = new Thread(frs3,"Srinu");
		
		t1.start();
		t2.start();
		t3.start();

	}

}
