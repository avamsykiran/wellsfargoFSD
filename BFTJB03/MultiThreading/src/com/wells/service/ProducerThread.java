package com.wells.service;

public class ProducerThread extends Thread{

	private JobExecutor je;

	public ProducerThread(JobExecutor je) {
		super();
		this.je = je;
	}
	
	@Override
	public void run() {
		try {
			je.produceJobs();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
