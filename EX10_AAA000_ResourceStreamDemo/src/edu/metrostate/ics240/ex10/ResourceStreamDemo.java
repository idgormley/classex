package edu.metrostate.ics240.ex10;

import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class ResourceStreamDemo {
	/**
	 * "scratch class" just to explore things. I definitely encourage you to
	 * write small sample programs to try out new things before plunging into
	 * the deep end of the problem. You need to give yourself enough time to do
	 * this, but don't think of it as a luxury: it will likely save you far more
	 * time debugging code that doesn't work.
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {

		final String filePath = "data/input.txt"; // try with and without a "/"
													// in front of data and
													// compare results
		final InputStream inputFile = ResourceStreamDemo.class.getResourceAsStream(filePath);
		final URL resourceURL = ResourceStreamDemo.class.getResource(filePath);

		System.out.println("URL: " + resourceURL);
		System.out.printf("File is %s null\n", inputFile == null ? "" : "not");

		final Scanner input = new Scanner(inputFile);

		while (input.hasNextLine()) {
			System.out.println(input.nextLine());
		}
		input.close();
	}
}
