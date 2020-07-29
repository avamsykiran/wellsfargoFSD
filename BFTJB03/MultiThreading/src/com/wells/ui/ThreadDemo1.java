package com.wells.ui;

public class ThreadDemo1 {
	public static void main(String a[]) {
		
		Thread t = Thread.currentThread();
		
		System.out.println(t.getName());
				
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("ThanQ");
	}
}
