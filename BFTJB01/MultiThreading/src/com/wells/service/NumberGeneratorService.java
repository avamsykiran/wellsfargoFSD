package com.wells.service;

import java.util.Random;

public class NumberGeneratorService implements Runnable {

	private Random rand;
	private int count;
	
	public NumberGeneratorService(int count) {
		this.rand = new Random();
		this.count=count;		
	}	
	
	public void generateSeries() {
		int counter=0;
		String threadName = Thread.currentThread().getName();
		
		while(counter<=count) {
			System.out.println(threadName+">> "+rand.nextInt(100));
			counter++;
			try {
				Thread.sleep(1200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void run() {
		generateSeries();
	}

}
