package com.wellsfargo.fsd.scdx.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class MessageProviderImpl implements MessageProvider {

	@Value("#{today.hour}") 
	private int h;
		
	public String getMessage() {
		String message=null;		
		
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
