package com.wellsfargo.batch5.basics.ui;

import com.wellsfargo.batch5.basics.service.DemoInterface;
import com.wellsfargo.batch5.basics.service.DemoInterfaceImpl;

public class DemoInterfaceApp {

	public static void main(String[] args) {
		DemoInterface di = new DemoInterfaceImpl();
		di.abstractMethod();
		di.defaultMethod();
		DemoInterface.staticMethod();
	}

}
