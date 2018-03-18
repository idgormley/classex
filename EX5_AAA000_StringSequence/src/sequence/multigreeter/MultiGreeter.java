package sequence.multigreeter;

import sequence.linkedlist.StringSequence;

public class MultiGreeter {
	
	public static final String DEFAULT_GREETING = "Hello";
	public static final int DEFAULT_CAPACITY = 3;
	public static final String DEFAULT_NAME = "World";
	
	private StringSequence greetings;
	private int greetCount;
	
	public MultiGreeter(){
		this(DEFAULT_CAPACITY);
	}
	public MultiGreeter(int maxGreetings) {
		greetings = new StringSequence();
		greetCount = 0;
	}

	public int getMaxGreetings(){
		return greetings.getCapacity();
	}
	
	public int getNumGreetings() {
		return greetings.size();
	}
	
	/**
	 * Adds greeting to this MultiGreeter's list of greetings
	 * @param greeting
	 */
	public void add(String greeting) {
		greetings.add(greeting);		
	}
	
	public String greet(String name) {
		final int numGreetings = greetings.size();
		String greeting = 		 String.format("%s, %s!", 
				numGreetings == 0 ? DEFAULT_GREETING : greetings.get(greetCount % numGreetings ),
				name);
		greetCount++;
		return greeting;
		
	}
	public String greet() {
		 return greet(DEFAULT_NAME);
	}
	/** 
	 * resets the greeting count to 0
	 */
	public void reset() {
		greetCount = 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
