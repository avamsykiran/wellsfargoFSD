package com.wellsfargo.fsd.swbd.service;

import java.time.LocalTime;

import org.springframework.stereotype.Service;
@Service
public class GreetServiceImpl implements GreetService {

	@Override
	public String greet(String userName) {
		String greeting = null;
		
		int h = LocalTime.now().getHour();
		
		if(h>=4 && h<=11) {
			greeting="Good Morning ";
		}else if(h>=12 && h<=15) {
			greeting="Good Noon ";
		}else {
			greeting="Good Evening ";
		}
		
		greeting += userName;
		
		return greeting;
	}

}
