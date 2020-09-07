package com.wellsfargo.scdx.service;

import java.time.LocalTime;

public class GreetingProviderImpl implements GreetingProvider {

	public String getGreeting() {
		String greeting=null;
		
		int h = LocalTime.now().getHour();
		
		if(h>=4 && h<=11) {
			greeting="Good Morning";
		}else if(h>=12 && h<=16) {
			greeting="Good Noon";
		}else  {
			greeting="Good Evening";
		}
		
		return greeting;
	}

}
