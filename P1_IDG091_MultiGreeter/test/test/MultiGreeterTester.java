package test;

import edu.metrostate.ics240.ex1.idg091.MultiGreeter;

public class MultiGreeterTester {

	public static void main(String[] args) {

		MultiGreeter a= new MultiGreeter(0);
		System.out.println(a.getNumGreetings());

		System.out.println(a.getMaxGreetings());
		System.out.println(a.addGreeting("hi"));
		
		System.out.println(a.getNumGreetings());

		
		
	}

}
