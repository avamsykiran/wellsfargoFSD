package com.wells.service;

public class ProducerThread extends Thread {

	private JobHandlingService jhs;

	public ProducerThread(JobHandlingService jhs) {	
		this.jhs = jhs;
	}
	
	@Override
	public void run() {
		try {
			jhs.produceJobs();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
