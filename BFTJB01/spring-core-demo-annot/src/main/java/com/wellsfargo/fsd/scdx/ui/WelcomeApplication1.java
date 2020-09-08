package com.wellsfargo.fsd.scdx.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wellsfargo.fsd.scdx.config.MyConfig;
import com.wellsfargo.fsd.scdx.service.WelcomeService;

public class WelcomeApplication1 {

	public static void main(String[] args) {
				
		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
	
		WelcomeService ws = (WelcomeService) context.getBean("ws");
		System.out.println(ws.doWelcome("Vamsy Kiran"));
		
		WelcomeService ws2 = (WelcomeService) context.getBean("wsa");
		System.out.println(ws2.doWelcome("Vamsy Kiran"));
		
		WelcomeService ws3 = (WelcomeService) context.getBean("wse");
		System.out.println(ws3.doWelcome("Vamsy Kiran"));
		
		System.out.println(context.getBean("today")); 
	}

}
