package com.wellsfargo.fsd.scdx.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wellsfargo.fsd.scdx.service.WelcomeService;
import com.wellsfargo.fsd.scdx.service.WelcomeServiceAdvancedImpl;

public class WelcomeApplication3 {

	public static void main(String[] args) {
				
		ApplicationContext context = new ClassPathXmlApplicationContext("beans3.xml");
		
		WelcomeService ws = (WelcomeService) context.getBean("wseb");
		System.out.println(ws.doWelcome("Vamsy Kiran"));
		
	}

}
