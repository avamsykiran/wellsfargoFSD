package com.wells.service;

public class ConsumerThread extends Thread {

	private JobHandlingService jhs;

	public ConsumerThread(JobHandlingService jhs) {	
		this.jhs = jhs;
	}
	
	@Override
	public void run() {
		try {
			jhs.consumeJobs();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
