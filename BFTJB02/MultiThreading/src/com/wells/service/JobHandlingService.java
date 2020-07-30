package com.wells.service;

import java.util.LinkedList;
import java.util.List;

public class JobHandlingService {

	private int capacity;
	private int jobCount;
	private List<Integer> jobsList;

	public JobHandlingService(int capacity, int jobCount) {
		this.capacity = capacity;
		this.jobCount = jobCount;
		this.jobsList = new LinkedList<>();
	}

	public void produceJobs() throws InterruptedException {
		for (int i = 1; i <= jobCount; i++) {
			synchronized (this) {
				while (jobsList.size() == capacity) {
					this.wait();
				}
				
				jobsList.add(i);
				System.out.println("Produce a job#"+i);
				
				this.notify();
				
				Thread.sleep(1000);
			}
		}
	}
	
	public void consumeJobs() throws InterruptedException {
		for (int i = 1; i <= jobCount; i++) {
			synchronized (this) {
				while (jobsList.isEmpty()) {
					wait();
				}
				
				int jobId = jobsList.remove(0);
				System.out.println("Consumed a job#"+jobId);
				
				notify();
				
				Thread.sleep(1000);
			}
		}
	}

}
