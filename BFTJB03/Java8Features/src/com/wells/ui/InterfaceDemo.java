package com.wells.ui;

import com.wells.service.CostComputingService;
import com.wells.service.CostComputingServiceGreedyImpl;
import com.wells.service.CostComputingServiceImpl;

public class InterfaceDemo {

	public static void main(String a[]) {
		CostComputingService ccs1 = new CostComputingServiceImpl();
		CostComputingService ccs2 = new CostComputingServiceGreedyImpl();
		
		System.out.println(ccs1.getSellingPrice(100));
		System.out.println(ccs2.getSellingPrice(100));
		
		System.out.println(ccs1.getTax(100));
		System.out.println(ccs2.getTax(100));
		
		System.out.println(CostComputingService.aStaticMethod());
	}
}
