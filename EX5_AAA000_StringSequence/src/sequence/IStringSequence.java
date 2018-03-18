package sequence;

public interface IStringSequence {

	int NOT_FOUND = -1;

	int getItemCount();

	/**
	 * Attempts to add string to Sequence. If Sequence is not dynamic and is full, will
	 * return false and Sequence will be unchanged.
	 * 
	 * @param string
	 *            string to be added to the Sequence
	 * @return true if item was added to Sequence, false otherwise
	 */
	boolean add(String string);

	/**
	 * Removes a specified string to this Sequence
	 * 
	 * @param string
	 *            string to be removed
	 * @return true if string was in Sequence and was successfully removed; false
	 *         otherwise
	 */
	boolean remove(String string);

	void remove(int itemIndex);

	// returns the index of the first occurrance of specified string in the
	// items array, or <code>NOT_FOUND</code> if items is not found
	int find(String string);

	/**
	 * Returns the number of occurrances of the name in this Sequence
	 * 
	 * @param string
	 *            string sought
	 * @return number of occurrances of name in Sequence
	 */
	int getCount(String string);

	/**
	 * Returns true if string is contained in this Sequence;
	 * 
	 * @param string
	 *            string sought
	 * @return true if there is at least one occurrance in the Sequence, false
	 *         otherwise
	 */
	boolean contains(String string);

	/**
	 * Returns the number of strings contained in this Sequence
	 * 
	 * @return number of strings in this Sequence
	 */
	int size();

	/**
	 * Returns the capacity of this Sequence
	 * 
	 * @return the capacity of this Sequence
	 */
	int getCapacity();

	/**
	 * Returns the string at a specified index of the list. The first string is located at index 0.
	 * 
	 * @param index index of the desired string
	 * @return string at specified index or <code>null</code> if index &ge; number of items in list.
	 * @throws IllegalArgumentException if index < 0;
	 */
	String get(int index);

}