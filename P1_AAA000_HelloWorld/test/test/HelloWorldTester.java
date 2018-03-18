package test;

import edu.metrostate.ics240.ex1.aaa000.HelloWorld;

public class HelloWorldTester {

	public static void main(String[] args) {

		HelloWorld hw = new HelloWorld();
		System.out.println(hw.getGreeting());

		hw.addName("Fred");
		System.out.println(hw.getGreeting());
		
		hw.addName("Barney");
		System.out.println(hw.getGreeting());

		hw.addName("Wilma");
		hw.addName("Betty");
		System.out.println(hw.getGreeting());
	}

}
