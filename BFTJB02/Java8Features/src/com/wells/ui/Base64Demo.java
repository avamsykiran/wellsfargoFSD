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
		
		System.out.print("Message: ");
		String msg = scan.next();
		
		String encodedMsg = encoder.encodeToString(msg.getBytes());
		System.out.println(encodedMsg);
		
		String decodedMsg = new String(decoder.decode(encodedMsg.getBytes()));
		System.out.println(decodedMsg);
	}

}
