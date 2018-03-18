package edu.metrostate.ics240.mt.idg091;

import java.util.LinkedList;
import java.util.List;

public class MultiGreeter {
	

	/**
	 * Returns a list of greetings of the form “Hello, name!” where the name is
	 * from the list of names provided. The order of names in the greetings will
	 * correspond to the order of names provided. If the provided names list is
	 * empty, the list of greetings will contain only the default greeting
	 * “Hello, World!”
	 * 
	 * If the provided names list is null, the method will throw a
	 * NullPointerException.
	 * 
	 * @param names
	 *            a list of names
	 * @return list of greetings of the form “Hello, name!” where the name is
	 *         from names. If names is empty, the list of greetings will contain
	 *         only the default greeting “Hello, World!”
	 */

	public static List<String> getGreetings(List<String> names) {
		List<String> greetings=new LinkedList<>();
		if (names == null) {
			throw new NullPointerException("Names list is null");
		} else {
			if (names.isEmpty()) {
				greetings.add("Hello, World!");
			}
			for (int i = 0; i < names.size(); i++) {
				greetings.add(String.format("Hello, %s!", names.get(i)));
			}
		}
		return greetings;

	}
}
