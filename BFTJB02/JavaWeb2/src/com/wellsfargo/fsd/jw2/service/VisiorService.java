package com.wellsfargo.fsd.jw2.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

import com.wellsfargo.fsd.jw2.model.VisitorModel;

public class VisiorService {

	public void computeAge(VisitorModel visitorModel) {
		Period p = Period.between(visitorModel.getDateOfBirth(), LocalDate.now());
		visitorModel.setAge(p.getYears());
	}
	
	public String getGreeting() {
		String greeting ="";
		
		int h = LocalTime.now().getHour();
		
		if(h>=4 && h<12) {
			greeting="Good Morning ";
		}else if(h>=12 &&  h<=16) {
			greeting="Good Noon ";
		}else {
			greeting="Good Evening ";
		}
				
		return greeting;
	}
}
