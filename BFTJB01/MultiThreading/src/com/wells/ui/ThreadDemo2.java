package com.wells.ui;

import com.wells.service.NumberGeneratorService;

public class ThreadDemo2 {

	public static void main(String[] args) {
		
		NumberGeneratorService ns1 = new NumberGeneratorService(10);
		NumberGeneratorService ns2 = new NumberGeneratorService(10);
		
		//ns1.generateSeries();
		//ns2.generateSeries();
		
		Thread t1 = new Thread(ns1);
		Thread t2 = new Thread(ns2);
		
		t1.start();
		t2.start();
		
	}

}
