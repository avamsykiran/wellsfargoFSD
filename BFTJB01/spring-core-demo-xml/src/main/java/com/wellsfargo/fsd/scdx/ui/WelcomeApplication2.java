package com.wellsfargo.fsd.scdx.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wellsfargo.fsd.scdx.service.WelcomeService;
import com.wellsfargo.fsd.scdx.service.WelcomeServiceAdvancedImpl;

public class WelcomeApplication2 {

	public static void main(String[] args) {
				
		ApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
		
		WelcomeService ws = (WelcomeService) context.getBean("wsab");
		System.out.println(ws.doWelcome("Vamsy Kiran"));
	
		((WelcomeServiceAdvancedImpl)ws).setWelcomeMessage("Hello!");
		System.out.println(ws.doWelcome("Vamsy Kiran"));
		
		WelcomeService ws2 = (WelcomeService) context.getBean("wsab");
		System.out.println(ws2.doWelcome("Vamsy Kiran"));
	}

}
