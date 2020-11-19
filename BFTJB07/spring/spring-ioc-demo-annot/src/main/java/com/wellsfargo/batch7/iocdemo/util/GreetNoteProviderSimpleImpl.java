package com.wellsfargo.batch7.iocdemo.util;

import org.springframework.stereotype.Component;

@Component
public class GreetNoteProviderSimpleImpl implements IGreetNoteProvider{

	@Override
	public String getGreetNote() {
		return "Hello! Welcome!";
	}

}
