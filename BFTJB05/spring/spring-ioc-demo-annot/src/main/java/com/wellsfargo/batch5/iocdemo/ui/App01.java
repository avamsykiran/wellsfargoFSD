package com.wellsfargo.batch5.iocdemo.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wellsfargo.batch5.iocdemo.config.MyConfig;
import com.wellsfargo.batch5.iocdemo.serivce.IGreetService;

public class App01 {

	public static void main(String[] args) {
		ApplicationContext context =
				new AnnotationConfigApplicationContext(MyConfig.class);
		
		IGreetService gs = (IGreetService) context.getBean("gsa");
		System.out.println(gs.getGreeting("Indhikaa"));
		
		System.out.println(context.getBean("current"));
	}

}
