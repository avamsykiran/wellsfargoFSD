package com.wellsfargo.scd.util;

import java.time.LocalTime;

import org.springframework.stereotype.Component;

@Component
public class GreetingProvider {

	public String getGreeting() {
		String greeting=null;
		
		int h = LocalTime.now().getHour();
		
		if(h>=4 && h<=11) {
			greeting="Good Morning";
		}else if(h>=12 && h<=16) {
			greeting ="Good Noon";
		}else {
			greeting="Good Evening";
		}
		
		return greeting;
	}
}


