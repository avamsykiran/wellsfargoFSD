package com.wellsfargo.batch5.iocdemo.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wellsfargo.batch5.iocdemo.serivce.Dummy;
import com.wellsfargo.batch5.iocdemo.serivce.GreetServiceImpl;
import com.wellsfargo.batch5.iocdemo.serivce.IGreetService;

public class App03 {

	public static void main(String[] args) {
		
		ApplicationContext context =
				new ClassPathXmlApplicationContext("beans3.xml");
		
		IGreetService gsadv = (IGreetService) context.getBean("gsadvBean");
		System.out.println(gsadv.getGreeting("Indhikaa"));
	}
}
