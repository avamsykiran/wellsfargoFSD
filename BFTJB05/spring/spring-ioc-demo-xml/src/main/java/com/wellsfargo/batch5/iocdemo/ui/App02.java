package com.wellsfargo.batch5.iocdemo.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wellsfargo.batch5.iocdemo.serivce.Dummy;
import com.wellsfargo.batch5.iocdemo.serivce.GreetServiceImpl;
import com.wellsfargo.batch5.iocdemo.serivce.IGreetService;

public class App02 {

	public static void main(String[] args) {
		
		ApplicationContext context =
				new ClassPathXmlApplicationContext("beans2.xml");
		
		Dummy copy1 = (Dummy) context.getBean("dBean");
		System.out.println(copy1.getCounter());
		Dummy copy2 = (Dummy) context.getBean("dBean");
		System.out.println(copy2.getCounter());
		Dummy copy3 = (Dummy) context.getBean("dBean");
		System.out.println(copy3.getCounter());
		Dummy copy4 = (Dummy) context.getBean("dBean");
		System.out.println(copy4.getCounter());
		
		((ClassPathXmlApplicationContext)context).close();		
		System.out.println("Program Done");
	}
}
