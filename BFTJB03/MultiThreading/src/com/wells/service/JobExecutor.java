package com.wells.service;

import java.util.LinkedList;
import java.util.List;

public class JobExecutor {

	private List<Integer> jobs;
	private int capacity;
	private int jobCount;

	public JobExecutor(int capacity, int jobCount) {
		super();
		this.capacity = capacity;
		this.jobCount = jobCount;
		this.jobs = new LinkedList<>();
	}

	private boolean isFull() {
		return jobs.size() == capacity;
	}

	private boolean isEmpty() {
		return jobs.isEmpty();
	}

	public void produceJobs() throws InterruptedException {
		for (int i = 0; i < jobCount; i++) {
			synchronized (this) {
				while (isFull()) {
					System.out.println("Producer waits");
					this.wait();
				}
				
				jobs.add(i);
				System.out.println("Produced a job#"+i);
				
				notify();
				
				Thread.sleep(1000);
			}
		}
	}
	
	public void consumeJobs() throws InterruptedException {
		for (int i = 0; i < jobCount; i++) {
			synchronized (this) {
				while (isEmpty()) {
					System.out.println("Consumer waits");
					this.wait();
				}
				
				int jobId = jobs.remove(0);
				System.out.println("Consumed a job#"+jobId);
				
				notify();
				
				Thread.sleep(1000);
			}
		}
	}
}
