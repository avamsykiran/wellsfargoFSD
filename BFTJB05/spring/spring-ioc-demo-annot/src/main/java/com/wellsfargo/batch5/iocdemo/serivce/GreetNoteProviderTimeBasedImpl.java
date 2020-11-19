package com.wellsfargo.batch5.iocdemo.serivce;

import java.time.LocalTime;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class GreetNoteProviderTimeBasedImpl implements IGreetNoteProvider {

	public String getGreetNote() {
		String greetNote="";
		
		int h = LocalTime.now().getHour();
		
		if(h>=4 && h<=11) {
			greetNote="Good Morning";
		}else if(h>=12 && h<=16) {
			greetNote="Good Noon";
		} else {
			greetNote="Good Evening";
		}
		
		return greetNote;
	}

}
