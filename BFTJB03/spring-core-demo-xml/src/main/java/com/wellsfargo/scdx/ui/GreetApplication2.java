package com.wellsfargo.scdx.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wellsfargo.scdx.service.GreetService;
import com.wellsfargo.scdx.service.GreetServiceAdvancedImpl;
import com.wellsfargo.scdx.service.GreetServiceImpl;

public class GreetApplication2 {

	public static void main(String[] args) {
	
		ApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
		
		GreetService gsa = (GreetService) context.getBean("gsab");
		System.out.println(gsa.greet("Vamsy"));
		
		((GreetServiceAdvancedImpl)gsa).setGreeting("Hai! ");
		System.out.println(gsa.greet("Vamsy"));
		
		gsa = (GreetService) context.getBean("gsab");
		System.out.println(gsa.greet("Vamsy"));
		
	}

}
