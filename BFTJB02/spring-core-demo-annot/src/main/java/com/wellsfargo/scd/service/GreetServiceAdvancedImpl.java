package com.wellsfargo.scd.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("gsab")
public class GreetServiceAdvancedImpl implements GreetService {

	@Value("Vannakkam!")
	private String greeting;
	
	public String doGreet(String userName) {
		return greeting +  " " + userName;
	}

}
