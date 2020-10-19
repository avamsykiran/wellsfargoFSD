package com.wellsfargo.batch5.basics.service;

public class DemoInterfaceImpl implements DemoInterface,DemoInterface2 {

	@Override
	public void abstractMethod() {
		System.out.println("an implementation for abstract method");
	}

	@Override
	public void defaultMethod() {
		DemoInterface.super.defaultMethod();
		DemoInterface2.super.defaultMethod();
	}

}
