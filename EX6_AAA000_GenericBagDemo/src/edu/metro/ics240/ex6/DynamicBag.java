package edu.metro.ics240.ex6;


/**
 * A dynamic StringBag that can increase its capacity as needed.
 * @author rfoy
 *
 */
public class DynamicBag<T> extends Bag<T> {

	public DynamicBag() {
		super();
	}

	public DynamicBag(int bagSize) {
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
	public boolean add(T item) {
		if (atCapacity()) {
			increaseCapacity();
		}
		return super.add(item);
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
