package com.wellsfargo.scd.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wellsfargo.scd.conf.MyConf;
import com.wellsfargo.scd.service.GreetService;
import com.wellsfargo.scd.service.GreetServiceImpl;

public class GreetApp1 {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(MyConf.class); 
		
		GreetService gs = (GreetService) context.getBean("gsb");
		System.out.println(gs.doGreet("Vamsy"));
		
		GreetService gsa = (GreetService) context.getBean("gsab");
		System.out.println(gsa.doGreet("Vamsy"));
		
		GreetService gse = (GreetService) context.getBean("gseb");
		System.out.println(gse.doGreet("Vamsy"));
		
		System.out.println(context.getBean("today"));
	}

}
