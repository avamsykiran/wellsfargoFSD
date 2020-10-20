package com.wellsfargo.batch5.threading.service;

public class Counter implements Runnable{
	
	private int start;
	private int stop;
	private int current;
	
	public Counter(int start, int stop) {
		super();
		this.start = start;
		this.stop = stop;
		this.current = start;
	}

	public void doCount() {
		String tName = Thread.currentThread().getName();
		while(current!=stop) {
			System.out.println(tName + ">> " + current);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
			current++;
		}
	}

	@Override
	public void run() {
		doCount();
	}

}
