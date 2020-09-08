package com.wellsfargo.scd.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wellsfargo.scd.service.GreetService;
import com.wellsfargo.scd.service.GreetServiceImpl;

public class GreetApp1 {

	public static void main(String[] args) {

		/*
		 * GreetService gs = new GreetServiceImpl();
		 * System.out.println(gs.doGreet("Vamsy"));
		 */

		ApplicationContext context = new ClassPathXmlApplicationContext("beans1.xml");
		
		GreetService gs = (GreetService) context.getBean("gsb");
		System.out.println(gs.doGreet("Vamsy"));
		
		GreetService gsa = (GreetService) context.getBean("gsab");
		System.out.println(gsa.doGreet("Vamsy"));
		
		GreetService gse = (GreetService) context.getBean("gseb");
		System.out.println(gse.doGreet("Vamsy"));
		
	}

}
