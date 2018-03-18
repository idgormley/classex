package bag;

/**
 * A static implementation of a Bag collection that can hold strings.
 * 
 * @author rfoy
 *
 */
public class StringBag {
	private static final int NOT_FOUND = -1;
	/**
	 * Default size of bag if not otherwise specified
	 */
	public final static int DEFAULT_BAG_SIZE = 16;
	private int itemCount;
	protected String[] items;
	
	protected int getItemCount(){
		return itemCount;
	}

	/**
	 * Creates a new StringBag of DEFAULT_BAG_SIZE
	 */
	public StringBag() {
		this(DEFAULT_BAG_SIZE);
	}

	/**
	 * Creates a new StringBag of specified <code>bagSize</code>, a non-negative
	 * number.
	 * 
	 * @param bagSize
	 *            initial size of bag, must be greater than 0
	 * @throws IllegalArgumentException
	 *             if bagSize is &le; 0
	 * @throws OutOfMemoryError
	 *             if there is insufficient memory to create the bag
	 */
	public StringBag(int bagSize) {
		if (bagSize > 0) {
			items = new String[bagSize];
		} else {
			throw new IllegalArgumentException("bag size must be >= 0");
		}
	}

	/**
	 * Attempts to add string to bag. If bag is not dynamic and is full, will return false and bag will be unchanged.
	 * 
	 * @param string  string to be added to the bag
	 * @return true if item was added to bag, false otherwise
	 */
	public boolean add(String string) {
		boolean added = false;
		if (itemCount < items.length) {
			items[itemCount] = string;
			itemCount++;
			added = true;
		}
		return added;
	}

	/**
	 * Removes a specified string to this bag
	 * 
	 * @param string
	 *            string to be removed
	 * @return true if string was in bag and was successfully removed; false
	 *         otherwise
	 */
	public boolean remove(String string) {
		int nameIndex = find(string);
		if (nameIndex >= 0) {
			items[nameIndex] = items[itemCount - 1];
			itemCount--;
		}
		return (nameIndex >= 0);
	}

	// returns the index of the first occurrance of specified string in the
	// items array, or <code>NOT_FOUND</code> if items is not found
	private int find(String string) {
		int firstIndex = NOT_FOUND;
		for (int i = 0; i < itemCount && firstIndex < 0; i++) {
			if (items[i].equals(string)) {
				firstIndex = i;
			}
		}
		return firstIndex;
	}

	/**
	 * Returns the number of occurrances of the name in this bag
	 * 
	 * @param string
	 *            string sought
	 * @return number of occurrances of name in bag
	 */
	public int getCount(String string) {
		int numFound = 0;
		for (int i = 0; i < itemCount; i++) {
			if (items[i].equals(string)) {
				numFound++;
			}
		}
		return numFound;
	}

	/**
	 * Returns true if string is contained in this bag;
	 * 
	 * @param string
	 *            string sought
	 * @return true if there is at least one occurrance in the bag, false
	 *         otherwise
	 */
	public boolean contains(String string) {
		return (find(string) >= 0);
	}

	/**
	 * Returns the number of strings contained in this bag
	 * 
	 * @return number of strings in this bag
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
