package com.wells.service;

public class ProducerThread extends Thread {

	PrinterService ps;
	
	public ProducerThread(PrinterService ps) {
		this.ps=ps;
	}
	
	public void run() {
		try {
			ps.produceJobs();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
