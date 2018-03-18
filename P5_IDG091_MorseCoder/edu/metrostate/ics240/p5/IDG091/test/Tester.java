package edu.metrostate.ics240.p5.IDG091.test;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.metrostate.ics240.p5.IDG091.morse.MorseCode;

public class Tester {

	@Test
	public void test() {
		String text = "Hello, World";
		String encodeTest = MorseCode.encode(text);
		System.out.printf(encodeTest);
		String decodeTest = MorseCode.decode("*");
		System.out.printf("decodeTest");
		
		assertEquals(text, decodeTest);
		assertEquals(encodeTest, MorseCode.encode(MorseCode.decode(encodeTest)));
	}

//	public void test2() {
//		String text = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890,.?!():;@";
//		String encodeTest = MorseCode.encode(text);
//		String decodeTest = MorseCode.decode(encodeTest);
//		assertEquals(text, decodeTest);
//		assertEquals(encodeTest, MorseCode.encode(MorseCode.decode(encodeTest)));
//
//	}
//
}
