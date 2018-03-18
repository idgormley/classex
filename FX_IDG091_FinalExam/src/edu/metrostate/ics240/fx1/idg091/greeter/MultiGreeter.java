package edu.metrostate.ics240.fx1.idg091.greeter;

import java.util.Stack;

public class MultiGreeter {
	private Stack<String> greetings;

	/**
	 * 
	 */
	MultiGreeter() {
		greetings = new Stack<String>();
	}

	/**
	 * Returns the actual number of greetings added to this greeter.
	 */
	public int getNumGreetings() {
		return greetings.size();
	}

	/**
	 * Adds a greeting to this Greeter.
	 * 
	 * @param greeting
	 */
	public void addGreeting(String greeting) {
		greetings.push(greeting);
	}

	/**
	 * Returns an array containing the greeting strings added to this Greeter
	 * 
	 * @return
	 */
	public String[] getGreetings() {
		String[] greets = (String[]) greetings.toArray();
		return greets;
	}

	/**
	 * Returns a salutation in the form “greetingString, name!”, where
	 * greetingString is one of the greeting strings displayed in sequence. That
	 * is, the first time greet is activated it will use the first greeting; the
	 * second time it will use the second. Once all of the greetings are used it
	 * will restart at the first greeting. When a greeting is added the count
	 * will reset and begin with the first greeting. If no greetings were added
	 * to the multiGreeter, the default greeting of “Hello” will be used.
	 * 
	 * @param name
	 *            a provided name.
	 * @return Returns a string in the form “greetingString, name!”
	 * 
	 */
	public String greet(String name) {
		String greetingString;
		String[] greetings = getGreetings();
		int i = 0;
		if (getNumGreetings() == 0)
			greetingString = "Hello, " + name + "!";
		else
			greetingString = greetings[i] + ", " + name + "!";

		i++;
		return greetingString;
	}

	/**
	 * 
	 * As specified above, however the system will use the default name, “World”
	 * 
	 * @return Returns a string in the form “greetingString, World!”
	 */
	public String greet() {
		String greetingString;
		String[] greetings = getGreetings();
		int i = 0;
		if (getNumGreetings() == 0)
			greetingString = "Hello, World!";
		else
			greetingString = greetings[i] + ", World!";
		i++;
		return greetingString;

	}
}
