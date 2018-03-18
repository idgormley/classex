package sequence.fixed;

import sequence.IStringSequence;

/**
 * A static implementation of a Sequence collection that can hold strings.
 * 
 * @author rfoy
 *
 */
public class StringSequence implements IStringSequence {
	/**
	 * Default size of Sequence if not otherwise specified
	 */
	public final static int DEFAULT_CAPACITY = 16;
	private int itemCount;
	protected String[] items;

	/* (non-Javadoc)
	 * @see sequence.fixed.IStringSequence#getItemCount()
	 */
	@Override
	public int getItemCount() {
		return itemCount;
	}

	/**
	 * Creates a new StringSequence of DEFAULT_CAPACITY size
	 */
	public StringSequence() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * Creates a new StringSequence of specified <code>SequenceSize</code>, a non-negative
	 * number.
	 * 
	 * @param SequenceSize
	 *            initial size of Sequence, must be greater than 0
	 * @throws IllegalArgumentException
	 *             if SequenceSize is &le; 0
	 * @throws OutOfMemoryError
	 *             if there is insufficient memory to create the Sequence
	 */
	public StringSequence(int SequenceSize) {
		if (SequenceSize > 0) {
			items = new String[SequenceSize];
		} else {
			throw new IllegalArgumentException("Sequence size must be >= 0");
		}
	}

	/* (non-Javadoc)
	 * @see sequence.fixed.IStringSequence#add(java.lang.String)
	 */
	@Override
	public boolean add(String string) {
		boolean added = false;
		if (itemCount < items.length) {
			items[itemCount] = string;
			itemCount++;
			added = true;
		}
		return added;
	}

	/* (non-Javadoc)
	 * @see sequence.fixed.IStringSequence#remove(java.lang.String)
	 */
	@Override
	public boolean remove(String string) {
		int nameIndex = find(string);
		if (nameIndex != NOT_FOUND) {
			remove(nameIndex);
		}
		return (nameIndex >= 0);
	}

	/* (non-Javadoc)
	 * @see sequence.fixed.IStringSequence#remove(int)
	 */
	@Override
	public void remove(int itemIndex) {
		if (itemIndex < 0 || itemIndex >= itemCount) {
			throw new IllegalArgumentException("index must be <= number of items: " + itemIndex);
		} else if (itemIndex >= 0) {
			System.arraycopy(items, itemIndex + 1, items, itemIndex, itemCount - itemIndex - 1);
			itemCount--;
		}
	}

	// returns the index of the first occurrance of specified string in the
	// items array, or <code>NOT_FOUND</code> if items is not found
	/* (non-Javadoc)
	 * @see sequence.fixed.IStringSequence#find(java.lang.String)
	 */
	@Override
	public int find(String string) {
		int firstIndex = NOT_FOUND;
		for (int i = 0; i < itemCount && firstIndex == NOT_FOUND; i++) {
			if (items[i].equals(string)) {
				firstIndex = i;
			}
		}
		return firstIndex;
	}

	/* (non-Javadoc)
	 * @see sequence.fixed.IStringSequence#getCount(java.lang.String)
	 */
	@Override
	public int getCount(String string) {
		int numFound = 0;
		for (int i = 0; i < itemCount; i++) {
			if (items[i].equals(string)) {
				numFound++;
			}
		}
		return numFound;
	}

	/* (non-Javadoc)
	 * @see sequence.fixed.IStringSequence#contains(java.lang.String)
	 */
	@Override
	public boolean contains(String string) {
		return (find(string) >= 0);
	}

	/* (non-Javadoc)
	 * @see sequence.fixed.IStringSequence#size()
	 */
	@Override
	public int size() {
		return itemCount;
	}

	/* (non-Javadoc)
	 * @see sequence.fixed.IStringSequence#getCapacity()
	 */
	@Override
	public int getCapacity() {
		return items.length;
	}

	/* (non-Javadoc)
	 * @see sequence.fixed.IStringSequence#get(int)
	 */
	@Override
	public String get(int index){
		if (index < 0) {
			throw new IllegalArgumentException("Index must be greater than 0");
		} else {
			return (index < itemCount) ? items[index] : null;
		}
	}
}
