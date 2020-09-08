package com.wellsfargo.scdx.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wellsfargo.scdx.conf.AppConf;
import com.wellsfargo.scdx.service.GreetService;
import com.wellsfargo.scdx.service.GreetServiceImpl;

public class GreetApplication1 {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConf.class);
		
		GreetService gs = (GreetService) context.getBean("gsb");
		System.out.println(gs.greet("Vamsy"));
		
		GreetService gsa = (GreetService) context.getBean("gsab");
		System.out.println(gsa.greet("Vamsy"));

		GreetService gse = (GreetService) context.getBean("gseb");
		System.out.println(gse.greet("Vamsy"));

		System.out.println(context.getBean("today"));
	}

}
