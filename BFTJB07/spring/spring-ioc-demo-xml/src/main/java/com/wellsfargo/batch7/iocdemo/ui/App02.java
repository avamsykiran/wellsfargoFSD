package com.wellsfargo.batch7.iocdemo.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wellsfargo.batch7.iocdemo.util.Dummy;

public class App02 {

	public static void main(String[] args) {

		ApplicationContext context=
				new ClassPathXmlApplicationContext("beans2.xml");
		
		Dummy copy1 = (Dummy) context.getBean("d");
		System.out.println(copy1.getCount());
		
		Dummy copy2 = (Dummy) context.getBean("d");
		System.out.println(copy2.getCount());
		
		Dummy copy3 = (Dummy) context.getBean("d");
		System.out.println(copy3.getCount());
		
		Dummy copy4 = (Dummy) context.getBean("d");
		System.out.println(copy4.getCount());
	}

}
