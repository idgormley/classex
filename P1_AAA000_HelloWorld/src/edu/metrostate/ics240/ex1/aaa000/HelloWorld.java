package edu.metrostate.ics240.ex1.aaa000;

public class HelloWorld {
	private static final int MAX_NUM_NAMES = 12;
	private String[] names;
	private int nameCount;

	/**
	 * Creates a HelloWorld object that can hold up to 12 names
	 */
	public HelloWorld() {
		names = new String[MAX_NUM_NAMES];
		nameCount = 0;
	}

	/**
	 * Returns a greeting string listing the names added, or the default name
	 * "World" if no names were added.
	 * 
	 * @return greeting string
	 */
	public String getGreeting() {

		StringBuilder nameList = new StringBuilder();
		// default
		if (nameCount == 0) {
			nameList.append("World");
		} else {
			for (int i = 0; i < nameCount; i++) {
				// comma separator between names
				if (i > 0 && nameCount > 2) {
					nameList.append(",");
				}
				// insert and before last name of list
				if (i > 0 && i == (nameCount - 1)) {
					nameList.append(" and");
				}
				
				// omit space if only one name
				if (nameCount != 1) { 
					nameList.append(' ');
				}
				nameList.append(names[i]);
			}
		}
		return "Hello" + (nameCount <= 1 ? ", " : "") + nameList.toString() + "!";
	}

	/**
	 * Adds name to HelloWorld object.
	 * @param name name to be added
	 * @throws IllegalArgumentException if maximum number of names were added
	 */
	public void addName(String name) {
		if (nameCount < MAX_NUM_NAMES) {
			names[nameCount] = name;
			nameCount++;
		} else {
			throw new IllegalArgumentException("Maximum number of names added");
		}
	}
}
