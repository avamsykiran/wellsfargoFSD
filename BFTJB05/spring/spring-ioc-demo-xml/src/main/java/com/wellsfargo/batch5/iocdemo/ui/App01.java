package com.wellsfargo.batch5.iocdemo.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wellsfargo.batch5.iocdemo.serivce.GreetServiceImpl;
import com.wellsfargo.batch5.iocdemo.serivce.IGreetService;

public class App01 {

	public static void main(String[] args) {
		
		ApplicationContext context =
				new ClassPathXmlApplicationContext("beans1.xml");
		
		//IGreetService gs = new GreetServiceImpl();
		IGreetService gs = (IGreetService) context.getBean("gsBean");
		System.out.println(gs.getGreeting("Indhikaa"));
		
		IGreetService gsa = (IGreetService) context.getBean("gsaBean");
		System.out.println(gsa.getGreeting("Indhikaa"));
		
		IGreetService gsa2 = (IGreetService) context.getBean("gsaBean2");
		System.out.println(gsa2.getGreeting("Indhikaa"));
		
		IGreetService gsadv = (IGreetService) context.getBean("gsadvBean");
		System.out.println(gsadv.getGreeting("Indhikaa"));
	}
}
