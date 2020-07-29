package com.wells.ui;

public class ThreadDemo1 {

	public static void main(String[] args) {
		
		Thread t = Thread.currentThread();
		
		System.out.println(t.getName());

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Program Terminated");
	}

}
