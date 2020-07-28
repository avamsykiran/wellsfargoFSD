package com.wells.ui;

import com.wells.service.DemoInterface;
import com.wells.service.DemoInterfaceImpl;

public class InterfaceDemoApp {

	public static void main(String[] args) {
		
		DemoInterface ref=new DemoInterfaceImpl();
		
		System.out.println(ref.aDefaultMethod());
		System.out.println(ref.anAbstractMethod());
		System.out.println(DemoInterface.aStaticMethod());

	}

}
