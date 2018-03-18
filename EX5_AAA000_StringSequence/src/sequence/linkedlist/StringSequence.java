/**
 * 
 */
package sequence.linkedlist;

import sequence.IStringSequence;

/**
 * @author rfoy
 *
 */
public class StringSequence implements IStringSequence {

	static class StringNode {
		private String value;
		private StringNode next;

		/**
		 * @return the next
		 */
		public StringNode getNext() {
			return next;
		}

		/**
		 * @param next
		 *            the next to set
		 */
		public void setNext(StringNode next) {
			this.next = next;
		}

		/**
		 * @return the value
		 */
		public String getValue() {
			return value;
		}

		public StringNode(String value) {
			super();
			this.value = value;
			this.next = null;
		}

	}

	public static int DEFAULT_CAPACITY = 0;
	private StringNode head;
	private StringNode tail;
	private int itemCount;
//
	public void printList(StringNode currNode) {
		if (currNode == null) {
			System.out.println();
		} else {
			printList(currNode.next);
			System.out.print(currNode.value);
			System.out.print("<-");

		}

	}

	public void testPrintList() {
		StringSequence s = new StringSequence();
		s.add("a");
		s.add("b");
		s.add("c");
		printList(s.head);
	}

	/**
	 * 
	 */
	public StringSequence() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sequence.IStringSequence#getItemCount()
	 */
	@Override
	public int getItemCount() {
		// TODO Auto-generated method stub
		return itemCount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sequence.IStringSequence#add(java.lang.String)
	 */
	@Override
	public boolean add(String string) {
		StringNode newNode = new StringNode(string);
		if (tail == null) {
			head = newNode;
		} else {
			tail.setNext(newNode);
		}
		tail = newNode;
		itemCount++;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sequence.IStringSequence#remove(java.lang.String)
	 */
	@Override
	public boolean remove(String string) {
		boolean removed = false;

		if (head != null) {
			StringNode prevNode = null;
			StringNode currNode = head;
			while (currNode != null && !currNode.getValue().equals(string)) {
				prevNode = currNode;
				currNode = currNode.getNext();
			}
			if (currNode != null) {
				if (prevNode == null) {
					// removing the head
					head = head.getNext();
				} else {
					prevNode.setNext(currNode.getNext());
				}
				if (currNode == tail) {
					// removing the tail
					tail = prevNode;
				}
				removed = true;
				itemCount--;
			}
		}
		return removed;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sequence.IStringSequence#remove(int)
	 */
	@Override
	public void remove(int itemIndex) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sequence.IStringSequence#find(java.lang.String)
	 */
	@Override
	public int find(String string) {
		int foundIndex = NOT_FOUND;
		StringNode currNode = head;

		for (int i = 0; currNode != null && foundIndex == NOT_FOUND; i++) {
			if (currNode.getValue().equals(string)) {
				foundIndex = i;
			} else {
				currNode = currNode.getNext();
			}
		}
		return currNode == null ? NOT_FOUND : foundIndex;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sequence.IStringSequence#getCount(java.lang.String)
	 */
	@Override
	public int getCount(String string) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sequence.IStringSequence#contains(java.lang.String)
	 */
	@Override
	public boolean contains(String string) {
		return find(string) != NOT_FOUND;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sequence.IStringSequence#size()
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sequence.IStringSequence#getCapacity()
	 */
	@Override
	public int getCapacity() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see sequence.IStringSequence#get(int)
	 */
	@Override
	public String get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

}
