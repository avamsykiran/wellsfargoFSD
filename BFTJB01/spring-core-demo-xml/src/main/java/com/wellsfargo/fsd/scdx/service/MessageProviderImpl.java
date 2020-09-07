package com.wellsfargo.fsd.scdx.service;

import java.time.LocalTime;

public class MessageProviderImpl implements MessageProvider {

	public String getMessage() {
		String message=null;
		
		int h = LocalTime.now().getHour();
		
		if(h>=4 && h<=11) {
			message = "Good Morning";
		}else if(h>=12 && h<=16) {
			message = "Good Noon";
		}else {
			message="Good Evening";
		}
		
		return message;
	}

	
}
