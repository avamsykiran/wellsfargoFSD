package com.wells.ui;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.Scanner;

public class Base64Demo {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter Message: ");
		String msg = scan.next();
		
		Encoder encoder = Base64.getEncoder();
		Decoder decoder = Base64.getDecoder();

		String encodedMsg = encoder.encodeToString(msg.getBytes());
		System.out.println(encodedMsg);
		
		String decodedMsg = new String(decoder.decode(encodedMsg));
		System.out.println(decodedMsg);
	}

}
