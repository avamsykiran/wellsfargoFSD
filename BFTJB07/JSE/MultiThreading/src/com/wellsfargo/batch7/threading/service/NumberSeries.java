package com.wellsfargo.batch7.threading.service;

import java.util.Random;

public class NumberSeries implements Runnable {

	private int maxElements;
	private int count;

	public NumberSeries(int maxElements) {
		this.maxElements = maxElements;
		this.count = 0;
	}

	public void doCount() {
		String tName = Thread.currentThread().getName();
		Random rand = new Random();

		while (count < maxElements) {
			System.out.println(tName + ">>" + rand.nextInt(100));
			count++;

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	@Override
	public void run() {
		doCount();
	}
}
