package edu.metro.ics240.ex6;

import java.util.Random;

/**
 * A static implementation of a Bag collection that can hold any reference type.
 * 
 * @author rfoy
 *
 */
public class Bag<T> {
	private static final long SEED = new java.util.Date().getTime();
	private static final Random RAND = new Random(SEED);
	
	private static final int NOT_FOUND = -1;
	/**
	 * Default size of bag if not otherwise specified
	 */
	public final static int DEFAULT_BAG_SIZE = 16;
	private int itemCount;
	protected Object [] items;
	
	protected int getItemCount(){
		return itemCount;
	}

	/**
	 * Creates a new Bag of DEFAULT_BAG_SIZE
	 */
	public Bag() {
		this(DEFAULT_BAG_SIZE);
	}

	/**
	 * Creates a new Bag of specified <code>bagSize</code>, a non-negative
	 * number.
	 * 
	 * @param bagSize
	 *            initial size of bag, must be greater than 0
	 * @throws IllegalArgumentException
	 *             if bagSize is &le; 0
	 * @throws OutOfMemoryError
	 *             if there is insufficient memory to create the bag
	 */
	public Bag(int bagSize) {
		if (bagSize > 0) {
			items = new Object [bagSize];
		} else {
			throw new IllegalArgumentException("bag size must be >= 0");
		}
	}

	/**
	 * Attempts to add an item to bag. If bag is not dynamic and is full, will return false and bag will be unchanged.
	 * 
	 * @param item  item to be added to the bag
	 * @return true if item was added to bag, false otherwise
	 */
	public boolean add(T item) {
		boolean added = false;
		if (itemCount < items.length) {
			items[itemCount] = item;
			itemCount++;
			added = true;
		}
		return added;
	}

	/**
	 * Removes a specified item frim this bag
	 * 
	 * @param item item to be removed
	 * @return true if item was in bag and was successfully removed; false
	 *         otherwise
	 */
	public boolean remove(T item) {
		int nameIndex = find(item);
		if (nameIndex >= 0) {
			items[nameIndex] = items[itemCount - 1];
			itemCount--;
		}
		return (nameIndex >= 0);
	}

	// returns the index of the first occurrance of specified string in the
	// items array, or <code>NOT_FOUND</code> if items is not found
	private int find(T item) {
		int firstIndex = NOT_FOUND;
		for (int i = 0; i < itemCount && firstIndex < 0; i++) {
			if (items[i].equals(item)) {
				firstIndex = i;
			}
		}
		return firstIndex;
	}

	/**
	 * Returns the number of occurrances of the item in this bag
	 * 
	 * @param item item sought
	 * @return number of occurrances of item in bag
	 */
	public int getCount(T item) {
		int numFound = 0;
		for (int i = 0; i < itemCount; i++) {
			if (items[i].equals(item)) {
				numFound++;
			}
		}
		return numFound;
	}

	/**
	 * Returns true if item is contained in this bag;
	 * 
	 * @param item item sought
	 * @return true if there is at least one occurrance in the bag, false
	 *         otherwise
	 */
	public boolean contains(T item) {
		return (find(item) >= 0);
	}

	@SuppressWarnings("unchecked")
	public T selectRandom(){
		return (T) items[RAND.nextInt(itemCount)];
	}
	/**
	 * Returns the number of items contained in this bag
	 * 
	 * @return number of items in this bag
	 */
	public int size() {
		return itemCount;
	}
	
	/**
	 * Returns the capacity of this bag
	 * @return the capacity of this bag
	 */
	public int getCapacity(){
		return items.length;
	}

}
