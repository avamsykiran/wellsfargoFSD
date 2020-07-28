package com.wells.ui;

import com.wells.service.GreetingService;
import com.wells.service.GreetingServiceEnglishImpl;
import com.wells.service.GreetingServiceHindiImpl;

public class InterfaceDemoApp {

	public static void main(String[] args) {
	
		GreetingService gs1 = new GreetingServiceEnglishImpl();
		GreetingService gs2 = new GreetingServiceHindiImpl();
		
		System.out.println(gs1.doGreet("Vamsy"));
		System.out.println(gs2.doGreet("Vamsy"));
		
		System.out.println(GreetingService.sayHello("Vamsy"));

	}

}
