package com.wellsfargo.batch7.basics.ui;

import java.util.Scanner;

public class RegExDemo {

	public static void main(String[] args) {
		String regExpMob = "[1-9][0-9]{9}";
		
		Scanner scan = new Scanner(System.in);
		System.out.print("mobile no: ");
		String mno = scan.next();
		
		if(mno.matches(regExpMob)) {
			System.out.println("VALID");
		}else {
			System.out.println("INVALID");
		}
	}

}
