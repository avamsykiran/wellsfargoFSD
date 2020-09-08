package com.wellsfargo.scd.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wellsfargo.scd.service.GreetService;
import com.wellsfargo.scd.service.GreetServiceImpl;

public class GreetApp3 {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans3.xml");
		
		GreetService gse = (GreetService) context.getBean("gseb");
		System.out.println(gse.doGreet("Vamsy"));
		
	}

}
