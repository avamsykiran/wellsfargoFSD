package com.wellsfargo.batch7.iocdemo.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wellsfargo.batch7.iocdemo.service.GreetServiceSimpleImpl;
import com.wellsfargo.batch7.iocdemo.service.IGreetService;

public class App03 {

	public static void main(String[] args) {

		ApplicationContext context=
				new ClassPathXmlApplicationContext("beans3.xml");
		
		IGreetService gsa = (IGreetService) context.getBean("gsaBean");
		System.out.println(gsa.getGreeting("Vamsy"));
		
		
	}

}
