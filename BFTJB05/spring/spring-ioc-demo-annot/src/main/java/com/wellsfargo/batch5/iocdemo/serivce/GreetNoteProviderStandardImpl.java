package com.wellsfargo.batch5.iocdemo.serivce;

import org.springframework.stereotype.Component;

@Component
public class GreetNoteProviderStandardImpl implements IGreetNoteProvider{

	public String getGreetNote() {
		return "Hello! Welcome!";
	}

}
