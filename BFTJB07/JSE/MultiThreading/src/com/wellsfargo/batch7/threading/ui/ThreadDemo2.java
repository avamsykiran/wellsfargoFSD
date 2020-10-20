package com.wellsfargo.batch7.threading.ui;

import com.wellsfargo.batch7.threading.service.NumberSeries;

public class ThreadDemo2 {

	public static void main(String[] args) {
		
		NumberSeries ns1 = new NumberSeries(10);
		NumberSeries ns2 = new NumberSeries(15);
		
		Thread t1 = new Thread(ns1, "Series1");
		Thread t2 = new Thread(ns2, "Series2");
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Bye! See You Soon!");
	}

}
