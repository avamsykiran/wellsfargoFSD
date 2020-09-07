package com.wellsfargo.fsd.scdx.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wellsfargo.fsd.scdx.service.WelcomeService;

public class WelcomeApplication1 {

	public static void main(String[] args) {

		//WelcomeService ws = new WelcomeServiceStandardImpl();
		//System.out.println(ws.doWelcome("Vamsy Kiran"));
				
		ApplicationContext context = new ClassPathXmlApplicationContext("beans1.xml");
	
		WelcomeService ws = (WelcomeService) context.getBean("wsb");
		System.out.println(ws.doWelcome("Vamsy Kiran"));
		
		WelcomeService ws2 = (WelcomeService) context.getBean("wsab1");
		System.out.println(ws2.doWelcome("Vamsy Kiran"));
		
		WelcomeService ws3 = (WelcomeService) context.getBean("wseb");
		System.out.println(ws3.doWelcome("Vamsy Kiran"));
	}

}
