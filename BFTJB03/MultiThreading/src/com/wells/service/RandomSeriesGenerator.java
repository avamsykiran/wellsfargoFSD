package com.wells.service;

import java.util.Random;

public class RandomSeriesGenerator implements Runnable{

	private Random random;
	private int count;
	
	public RandomSeriesGenerator(int count) {
		this.random = new Random();
		this.count = count;
	}
	
	public void generateSeries() {
		String tName = Thread.currentThread().getName();
		
		for(int counter=0;counter<=count;counter++) {
			System.out.println(tName + ">> "+random.nextInt(100));
			
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
