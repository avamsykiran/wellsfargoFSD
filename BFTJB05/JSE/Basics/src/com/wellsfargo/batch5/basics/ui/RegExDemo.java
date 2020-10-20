package com.wellsfargo.batch5.basics.ui;

import java.util.Scanner;

public class RegExDemo {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("mobile number: ");
		String mob = scan.next();
		
		String mobRegEx = "[1-9]\\d{9}";
		
		if(mob.matches(mobRegEx)) {
			System.out.println("VALID");
		}else {
			System.out.println("INVALID");
		}
	}

}
