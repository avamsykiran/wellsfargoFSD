package com.wells.service;

public class ProducerConsumrApp {

	public static void main(String[] args) {
		
		JobHandlingService jhs = new JobHandlingService(5, 10);
		
		ProducerThread pt = new ProducerThread(jhs);
		ConsumerThread ct = new ConsumerThread(jhs);
		
		ct.start();
		pt.start();
		
	}

}
