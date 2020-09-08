package com.wellsfargo.scdx.service;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class GreetingProviderImpl implements GreetingProvider {

	@Value("#{today.hour}")
	private int h;
	
	public String getGreeting() {
		String greeting=null;
		
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
