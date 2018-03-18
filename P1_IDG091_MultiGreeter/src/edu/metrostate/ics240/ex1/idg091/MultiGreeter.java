package edu.metrostate.ics240.ex1.idg091;
/**
 * @author Ian Gormley
 *
 */
public class MultiGreeter {
	static public String [] greetings;
	private int greetingCount;
	private int i;
	private int maxGreetings;	
	private static final int DEFAULT_MAX_GREETINGS=8;
	
/**
 * Create a MultiGreeter object that can hold up to DEFAULT_MAX_GREETINGS greetings, set at 8;
 * Sets greetingCount to 0.
 */
	public MultiGreeter() {
		greetings=new String[DEFAULT_MAX_GREETINGS];
		greetingCount=0;
	}	
/**
 * Creates a MultiGreeter object that can hold a specified amount of greetings.
 * Sets greetingCount to 0
 * @param maxGreeting
 * The Maximum number of greetings that can be added.
 * @throws IllegalArgumentException 
 * Indicates that maxGreeting must be non-negative.
 */
	public MultiGreeter(int maxGreeting){
		if (maxGreeting>=0){
			maxGreetings=maxGreeting;
			greetings=new String[maxGreetings];
			greetingCount=0;
			}
		else{
			throw new IllegalArgumentException("MultiGreeter(MaxGreeting) must be Non-Negative.");
		}
	}	
/**
 * @return Array containing all greeting strings added to the Greeter.
 */
	public String[] getGreetings(){	
		return greetings;
	}
/**
 * @return The maximum number of greetings that can be added to the Greeter.
 */
	public int getMaxGreetings(){
		return greetings.length;
		}
/**	
 * @return The number of greetings added to the Greeter by the user.
 */
	public int getNumGreetings(){
		return greetingCount;
		}
/**
 * Adds a greeting to the Greeter.
 * If the Greeter already has maxGreetings added, the greeting will not be added and the method will return false;
 * otherwise the method will return true.
 * @param greeting Greeting to be added to the Greeter.
 * @return False if greetingCount is greater than MaxGreetings. 
 * Otherwise the method will return true.
 */
	public boolean addGreeting(String greeting){
		if (greetingCount<=maxGreetings){
			greetings[greetingCount]=greeting;
			greetingCount=greetingCount+1;
			return true;}
		return false;
		}	
/**
 *@param name a provided name. 
 * @return String in the form “greetingString, name!”, where greetingString is one of the greeting strings added to the Greeter picked at random.
 * If no greetings have been added, the system will use the default greeting "Hello"
 */
	public String greet(String name) {
		if (greetingCount==0)
			greetings[0]="Hello";
		else
			i = (int)(Math.random()*greetingCount);
		return greetings[i] +", "+ name+" !";
	}
/**
 * @return String in the form “greetingString, World!”, where greetingString is one of the greeting strings added to the Greeter picked at random.
 * If no greetings have been added, the system will use the default greeting "Hello" 
 */
	public String greet(){
		if (greetingCount==0)
			greetings[0]="Hello";
		else
			i = (int)(Math.random()*greetingCount);
		return greetings[i] +", World!";
	}
}
