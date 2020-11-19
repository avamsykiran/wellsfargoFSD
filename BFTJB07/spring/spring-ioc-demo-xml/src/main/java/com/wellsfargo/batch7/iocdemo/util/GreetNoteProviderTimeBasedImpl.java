package com.wellsfargo.batch7.iocdemo.util;

import java.time.LocalTime;

public class GreetNoteProviderTimeBasedImpl implements IGreetNoteProvider{

	@Override
	public String getGreetNote() {
		
		String greeting="";
		
		int h = LocalTime.now().getHour();
		
		if(h>=4 && h<=11) {
			greeting="Good Morning";
		}else if(h>=12 && h<=17) {
			greeting="Good Noon";
		} else {
			greeting="Good Evening";
		}
		
		return greeting;
	}
}