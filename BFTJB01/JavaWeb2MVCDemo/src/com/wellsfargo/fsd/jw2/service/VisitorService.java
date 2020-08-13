package com.wellsfargo.fsd.jw2.service;

import java.time.LocalTime;

import com.wellsfargo.fsd.jw2.model.VisitorModel;

public class VisitorService {
	
	public String greet(VisitorModel visitorModel) {
		String result ="";
		
		int h = LocalTime.now().getHour();
		
		if(h>=4 && h<12) {
			result = "Good Morning ";
		}else if(h>=12 && h<=16) {
			result = "Good Noon ";
		}else {
			result = "Good Evening ";
		}
		
		if("NA".equals(visitorModel.getTitle())){
			if("G".equals(visitorModel.getGender())) {
				result += "Mr.";
			}else {
				result += "Miss.";
			}
		}else {
			result += visitorModel.getTitle();
		}
		
		result += visitorModel.getFullName();
		
		return result;
	}

}
