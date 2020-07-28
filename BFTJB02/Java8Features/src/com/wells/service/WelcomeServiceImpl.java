package com.wells.service;

public class WelcomeServiceImpl implements WelcomeService {

	@Override
	public String welcome(String username) {
		return "Welcome! "+username;
	}

}
