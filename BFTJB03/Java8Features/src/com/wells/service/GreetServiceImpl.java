package com.wells.service;

public class GreetServiceImpl implements GreetService {

	@Override
	public String greet(String username) {
		return "Hello "+username;
	}

}
