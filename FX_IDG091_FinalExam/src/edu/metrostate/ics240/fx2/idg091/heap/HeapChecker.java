package edu.metrostate.ics240.fx2.idg091.heap;

public class HeapChecker {
	/**
	 * @param intArray
	 *            Array to be checked.
	 * @return true if array is a valid max heap.
	 * @throws NullPointerException
	 *             if intArray is null
	 */
	public static boolean isValid(Integer[] intArray) {
		boolean valid = false;
		int i = 1;

		if (intArray != null) {
			if (intArray.length == 0 || intArray.length == 1) {
				valid = true;
			}
			if (isGreater(intArray, i)) {
				valid = true;
			}
		} else {
			throw new NullPointerException();
		}
		return valid;
	}

	private static boolean isGreater(Integer[] intArray, int i) {
		boolean greater = false;
		 Integer parent = intArray[i - 1];
		 Integer lChild = intArray[i * 2 - 1];
		 Integer rChild = intArray[i * 2];
		if (parent > lChild && parent > rChild&&parent!=null&&lChild!=null&&rChild!=null){
			greater = true;
		}
		if (intArray.length > i) {
			i++;
			isGreater(intArray, i);
		}
		return greater;
	}
}
