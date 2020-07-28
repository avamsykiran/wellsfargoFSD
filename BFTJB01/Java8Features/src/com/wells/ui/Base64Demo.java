package com.wells.ui;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.Scanner;

public class Base64Demo {

	public static void main(String[] args) {
		
		Encoder encoder = Base64.getEncoder();
		Decoder decoder = Base64.getDecoder();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("A message : ");
		String msg = scan.next();
		
		String encodedString = encoder.encodeToString(msg.getBytes());
		System.out.println(encodedString);
		
		byte[] decodedData = decoder.decode(encodedString);
		String decodedStr = new String(decodedData);
		System.out.println(decodedData);
		System.out.println(decodedStr);
				
		scan.close();

	}

}
