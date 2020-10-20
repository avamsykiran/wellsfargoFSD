package com.wellsfargo.batch5.threading.ui;

public class ThreadDemo {

	public static void main(String[] args) {
		Thread t = Thread.currentThread();
		
		System.out.println(t.getName());
	}

}
