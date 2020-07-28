package com.wells.ui;

import java.time.LocalTime;

import com.wells.service.WelcomeService;
import com.wells.service.WelcomeServiceImpl;

public class WelcomeApp {

	public static void main(String[] args) {
		
		WelcomeService ws1 = new WelcomeServiceImpl();
		System.out.println(ws1.welcome("Vamsy"));
		
		WelcomeService ws2 = new WelcomeService() {
			
			@Override
			public String welcome(String username) {
				return "Padhariye! " + username;
			}
		};
		System.out.println(ws2.welcome("Vamsy"));
		
		WelcomeService ws3 = (unm) -> "Please come " + unm;
		System.out.println(ws3.welcome("Vamsy"));
		
		WelcomeService ws4 = (unm) -> { 
			int h = LocalTime.now().getHour();
			
			String greet="";
			
			if(h>=4 && h<=11) greet="Good Morning ";
			else if(h>11 && h<=16) greet="Good Noon ";
			else greet="Good Evening ";
			
			return greet + unm; 
		};
		System.out.println(ws4.welcome("Vamsy"));
		
	}

}
