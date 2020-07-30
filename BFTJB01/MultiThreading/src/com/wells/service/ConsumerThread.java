package com.wells.service;

public class ConsumerThread extends Thread {

	PrinterService ps;
	
	public ConsumerThread(PrinterService ps) {
		this.ps=ps;
	}
	
	public void run() {
		try {
			ps.consumeJobs();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
