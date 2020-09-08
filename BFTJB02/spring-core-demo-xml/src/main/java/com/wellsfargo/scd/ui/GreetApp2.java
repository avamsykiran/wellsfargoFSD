package com.wellsfargo.scd.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wellsfargo.scd.service.GreetService;
import com.wellsfargo.scd.service.GreetServiceAdvancedImpl;
import com.wellsfargo.scd.service.GreetServiceImpl;

public class GreetApp2 {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
		
		GreetService gs1 = (GreetService) context.getBean("gsab1");
		System.out.println(gs1.doGreet("Vamsy"));
		
		GreetService gs2 = (GreetService) context.getBean("gsab2");
		System.out.println(gs2.doGreet("Vamsy"));
		
		((GreetServiceAdvancedImpl)gs1).setGreeting("Hello");
		System.out.println(gs1.doGreet("Vamsy"));
		
		((GreetServiceAdvancedImpl)gs2).setGreeting("Hello");
		System.out.println(gs2.doGreet("Vamsy"));
		
		GreetService gs11 = (GreetService) context.getBean("gsab1");
		System.out.println(gs11.doGreet("Vamsy"));
		
		GreetService gs21 = (GreetService) context.getBean("gsab2");
		System.out.println(gs21.doGreet("Vamsy"));
		
	}

}
