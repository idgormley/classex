package edu.metro.ics240.ex6;

import static org.junit.Assert.*;

import org.junit.Test;

public class BagTest {
	
	@Test
	public void testAddRemove() {
		Bag<String> sb = new Bag<String>();
		assertEquals(0, sb.size());
		assertTrue(sb.add("Fred"));
		assertEquals(1, sb.size());
		assertTrue(sb.contains("Fred"));
		assertEquals(1, sb.getCount("Fred"));
		assertTrue(sb.add("Fred"));
		assertEquals(2, sb.getCount("Fred"));
		assertTrue(sb.remove("Fred"));
		assertTrue(sb.contains("Fred"));
		assertEquals(1, sb.getCount("Fred"));
		assertTrue(sb.remove("Fred"));
		assertFalse(sb.contains("Fred"));
		assertEquals(0, sb.getCount("Fred"));
	}

	@Test
	public void testAddBoundary() {
		int bagSize = 4;
		Bag<String> sb = new Bag<String>(bagSize);

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
		Bag<String> sb = new DynamicBag<String>(initialBagSize);
		
		assertEquals(initialBagSize, sb.getCapacity());
		for (int i = 0; i < initialBagSize; i++) {
			assertTrue(sb.add(String.format("String_%d", i)));
			assertEquals(i + 1, sb.size());
		}
		assertTrue(sb.add("One too many"));
		assertEquals(initialBagSize + 1, sb.size());
		assertTrue(sb.getCapacity() > initialBagSize); // capacity increased
	}
	
	
	@Test
	public void testDouble(){
		Bag<Double> doubles = new Bag<>();
		Double age = 29.5;
		
		assertEquals(0, doubles.size());
		doubles.add(age);
		assertEquals(1, doubles.size());
		assertTrue(doubles.contains(age));
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
}
