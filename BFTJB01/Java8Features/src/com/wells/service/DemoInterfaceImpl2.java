package com.wells.service;

public class DemoInterfaceImpl2 implements DemoInterface{
	
	@Override
	public String anAbstractMethod() {
		return "this is the implementation2 of the abastract method";
	}

	@Override
	public String aDefaultMethod() {		 
		return "this is an overriden defualt method";
	}

	
}
