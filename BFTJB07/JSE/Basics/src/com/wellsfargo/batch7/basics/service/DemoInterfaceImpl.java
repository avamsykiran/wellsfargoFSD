package com.wellsfargo.batch7.basics.service;

public class DemoInterfaceImpl implements DemoInterface,DemoInterface2 {

	@Override
	public void abstractMethod() {
		System.out.println("an abstract method Impl");
	}

	@Override
	public void defaultMethod() {
		DemoInterface.super.defaultMethod();
		DemoInterface2.super.defaultMethod();
	}

}
