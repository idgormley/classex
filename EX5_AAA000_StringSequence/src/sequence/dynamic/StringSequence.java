package sequence.dynamic;

/**
 * A dynamic StringBag that can increase its capacity as needed.
 * @author rfoy
 *
 */
public class StringSequence extends sequence.fixed.StringSequence {

	public StringSequence() {
		super();
	}

	public StringSequence(int bagSize) {
		super(bagSize);
	}

	/**
	 * Adds string to dynamic bag. Bag capacity will automatically increase as
	 * needed
	 * 
	 * @return true is successfully added
	 * @throws OutOfMemoryError
	 *             if there is insufficient memory
	 */
	@Override
	public boolean add(String string) {
		if (atCapacity()) {
			increaseCapacity();
		}
		return super.add(string);
	}

	private void increaseCapacity() {
		String[] tmpItems = new String[(items.length * 2) + 1];
		System.arraycopy(items, 0, tmpItems, 0, items.length);
		items = tmpItems;
	}

	private boolean atCapacity() {
		return this.getItemCount() == items.length;
	}
}
