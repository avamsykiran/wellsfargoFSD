package com.wells.ui;

import com.wells.service.RandomSeriesGenerator;

public class ThreadDemo2 {

	public static void main(String[] args) {
		RandomSeriesGenerator g1 = new RandomSeriesGenerator(10);
		RandomSeriesGenerator g2 = new RandomSeriesGenerator(13);

		//g1.generateSeries();
		//g2.generateSeries();
		
		Thread t1=new Thread(g1,"t1");
		Thread t2=new Thread(g2,"t2");
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		System.out.println("Program Terminated!");
	}

}
