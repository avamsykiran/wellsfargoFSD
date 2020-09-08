package com.wellsfargo.scdx.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wellsfargo.scdx.service.GreetService;
import com.wellsfargo.scdx.service.GreetServiceImpl;

public class GreetApplication3 {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans3.xml");
		
		GreetService gse = (GreetService) context.getBean("gseb");
		System.out.println(gse.greet("Vamsy"));

		
	}

}
