package com.wells.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class PrinterService {

	List<Integer> printJobs;
	int maxJobCount;
	int jobCount;

	public PrinterService(int maxJobCount, int jobCount) {
		this.maxJobCount = maxJobCount;
		this.jobCount = jobCount;
		printJobs = new LinkedList<>();
	}

	public void produceJobs() throws InterruptedException {
		Random rand = new Random();

		for (int i = 0; i < jobCount; i++) {
			synchronized (this) {

				while (printJobs.size() == maxJobCount) {
					wait();
				}

				int jobId = rand.nextInt(100);
				printJobs.add(jobId);
				System.out.println("produced a new Job#" + jobId);

				notify();

				Thread.sleep(500);
			}
		}
	}

	public void consumeJobs() throws InterruptedException {

		for (int i = 0; i < jobCount; i++) {
			synchronized (this) {

				while (printJobs.isEmpty()) {
					wait();
				}

				int jobId = printJobs.remove(0);
				System.out.println("consumed a Job#" + jobId);

				notify();

				Thread.sleep(500);
			}
		}
	}

}
