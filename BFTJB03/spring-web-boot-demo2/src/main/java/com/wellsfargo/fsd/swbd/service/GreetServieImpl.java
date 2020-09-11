package com.wellsfargo.fsd.swbd.service;

import java.time.LocalTime;

import org.springframework.stereotype.Service;

@Service
public class GreetServieImpl implements GreetService {

	@Override
	public String doGreet(String userName) {
		String greet=null;
		
		int h= LocalTime.now().getHour();
		
		if(h>=4 && h<=11) {
			greet = "Good Morning";
		}else if(h>=12 && h<=16) {
			greet = "Good Noon";
		}else {
			greet="Good Evening";
		}
		
		return greet + " " + userName;
	}

}
