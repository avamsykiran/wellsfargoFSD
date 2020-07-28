package com.wells.ui;

import com.wells.service.GreetService;
import com.wells.service.GreetServiceImpl;

public class LambdaDemo {

	public static void main(String[] args) {
		
		GreetService gs = new GreetServiceImpl();
		System.out.println(gs.greet("Vamsy"));
		
		GreetService gs2 = (unm) -> "Namaskar! " + unm;
		System.out.println(gs2.greet("Vamsy"));
		
	}

}
