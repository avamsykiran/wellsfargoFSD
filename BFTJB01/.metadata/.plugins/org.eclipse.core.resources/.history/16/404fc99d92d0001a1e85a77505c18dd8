package com.wells.ui;

import java.time.LocalDateTime;

import com.wells.service.SomeService2;

public class FunctionalInterfaceDemo {

	public static void main(String[] args) {
		
		/*
		 * SomeService ser1 = new SomeServiceImpl();
		 * 
		 * SomeService ser2 = new SomeService() {
		 * 
		 * @Override public String method2() { return null; }
		 * 
		 * @Override public String method1() { return null; } };
		 */
		
		SomeService2 ser2Obj = (unm) -> "Hello "+unm;
		System.out.println(ser2Obj.method1("Vamsy"));
		
		SomeService2 ser2Obj2 = (unm) -> {
			int hour = LocalDateTime.now().getHour();
			
			String greet="";
			if(hour>=4 && hour<=11) greet="Good Morning";
			else if(hour>11 && hour<=15) greet="Good Noon";
			else greet="Good Evening";
			
			return greet+" "+unm;
		};
		System.out.println(ser2Obj2.method1("Vamsy"));
	}

}
