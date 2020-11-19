package com.wellsfargo.batch7.iocdemo.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wellsfargo.batch7.iocdemo.service.GreetServiceSimpleImpl;
import com.wellsfargo.batch7.iocdemo.service.IGreetService;

public class App01 {

	public static void main(String[] args) {

		ApplicationContext context=
				new ClassPathXmlApplicationContext("beans1.xml");
		
		//IGreetService gs = new GreetServiceSimpleImpl();
		IGreetService gs = (IGreetService) context.getBean("gsBean");
		System.out.println(gs.getGreeting("Vamsy"));
		
		IGreetService gsp = (IGreetService) context.getBean("gspBean");
		System.out.println(gsp.getGreeting("Vamsy"));
		
		IGreetService gsa = (IGreetService) context.getBean("gsaBean");
		System.out.println(gsa.getGreeting("Vamsy"));
		
		
	}

}
