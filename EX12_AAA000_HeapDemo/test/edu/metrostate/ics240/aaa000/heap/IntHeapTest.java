package edu.metrostate.ics240.aaa000.heap;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class IntHeapTest {
	public final static long SEED = 20170720001L;
	
	@Test
	public void testAdd() {
		IntHeap myHeap = new IntHeap();
		assertTrue(myHeap.isEmpty());
		for (int i = 1; i <= 15; i++) {
			myHeap.add(i);
			assertEquals(i, myHeap.size());
			assertEquals(i, myHeap.peek());
		}
		myHeap.printHeap();
	}

	@Test
	public void testRemove() {
		IntHeap myHeap = new IntHeap();
		Random rand = new Random(SEED);
		final int NUM_VALS = 100;
		for (int i = 0; i < NUM_VALS; i++) {
			myHeap.add(rand.nextInt(1000));
		}
		int lastValue = Integer.MAX_VALUE;
		for (int i = 100; i > 0; i--) {
			assertTrue(myHeap.peek() <= lastValue);
			lastValue = myHeap.remove();
		}
	}

}
