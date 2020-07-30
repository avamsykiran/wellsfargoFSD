package com.wells.ui;

import com.wells.service.ConsumerThread;
import com.wells.service.PrinterService;
import com.wells.service.ProducerThread;

public class ProducerConsumerApp {

	public static void main(String[] args) {
		
		PrinterService ps = new PrinterService(5, 15);
		
		ProducerThread pt = new ProducerThread(ps);
		ConsumerThread cs = new ConsumerThread(ps);
		
		pt.start();
		cs.start();
				
		try {
			pt.join();
			cs.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("Jobs Done");

	}

}
