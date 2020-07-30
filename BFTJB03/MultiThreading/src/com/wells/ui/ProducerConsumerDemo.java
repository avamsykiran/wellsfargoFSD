package com.wells.ui;

import com.wells.service.ConsumerThread;
import com.wells.service.JobExecutor;
import com.wells.service.ProducerThread;

public class ProducerConsumerDemo {

	public static void main(String[] args) {

		JobExecutor je = new JobExecutor(5, 10);
		
		ProducerThread pt = new ProducerThread(je);
		ConsumerThread ct = new ConsumerThread(je);
		
		ct.start();
		pt.start();
	}

}
