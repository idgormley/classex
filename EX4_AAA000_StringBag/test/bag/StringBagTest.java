package bag;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringBagTest {

	@Test
	public void testAddRemove() {
		StringBag sb = new StringBag();
		assertEquals(0, sb.size());
		sb.add("Fred");
		assertEquals(1, sb.size());
		assertTrue(sb.contains("Fred"));
		assertEquals(1, sb.getCount("Fred"));

		assertTrue(sb.remove("Fred"));
		assertFalse(sb.contains("Fred"));
		assertEquals(0, sb.getCount("Fred"));
		assertFalse(sb.remove("Fred"));

	}

	@Test
	public void testAddBoundary() {
		int bagSize = 4;
		StringBag sb = new StringBag(bagSize);

		assertEquals(bagSize, sb.getCapacity());
		for (int i = 0; i < bagSize; i++) {
			assertTrue(sb.add(String.format("String_%d", i)));
			assertEquals(i + 1, sb.size());
		}
		assertFalse(sb.add("One too many"));
		assertEquals(bagSize, sb.getCapacity()); //capacity not changed
	}
	
	@Test
	public void testAddBoundaryDynamic() {
		int initialBagSize = 4;
		StringBag sb = new DynamicStringBag(initialBagSize);
		
		assertEquals(initialBagSize, sb.getCapacity());
		for (int i = 0; i < initialBagSize; i++) {
			assertTrue(sb.add(String.format("String_%d", i)));
			assertEquals(i + 1, sb.size());
		}
		assertTrue(sb.add("One too many"));
		assertEquals(initialBagSize + 1, sb.size());
		assertTrue(sb.getCapacity() > initialBagSize); // capacity increased
	}
}
