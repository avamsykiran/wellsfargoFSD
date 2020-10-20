package com.wellsfargo.batch5.threading.ui;

import com.wellsfargo.batch5.threading.service.Counter;

public class ThreadDemo2 {

	public static void main(String[] args) {
		
		Counter c1 = new Counter(100, 120);
		Counter c2 = new Counter(200, 220);
		
		Thread t1 = new Thread(c1, "counter 1");
		Thread t2 = new Thread(c2, "counter 2");

		t1.start();
		t2.start();
				
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("The program is done!");
	}

}
