package sequence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

import sequence.linkedlist.StringSequence;

public class StringSequenceTest {

	private static long SEED = 20170530001L;
	private static final Random RAND = new Random(SEED);

	@Test
	public void testAdd() {
		IStringSequence strings = new StringSequence();
		assertEquals(StringSequence.DEFAULT_CAPACITY, strings.getCapacity());
		assertEquals(0, strings.getItemCount());

		strings.add("Wilkommen");

		assertEquals(StringSequence.DEFAULT_CAPACITY, strings.getCapacity());
		assertEquals(1, strings.getItemCount());
	}

	@Test
	public void testFind() {
		IStringSequence strings = new StringSequence();
		final String s = "Wilkommen";

		strings.add(s);
		assertTrue(strings.contains(s));
		assertEquals(0, strings.find(s));

		assertFalse(strings.contains("Frog"));
		assertEquals(IStringSequence.NOT_FOUND, strings.find("Frog"));

	}

	@Test
	public void testRemoveFirst() {
		IStringSequence strings = new StringSequence();

		strings.add("Wilkommen");
		strings.add("Welcome");
		strings.add("Bienvenue");

		assertEquals(3, strings.getItemCount());
		assertTrue(strings.contains("Welcome"));

		assertTrue(strings.remove("Welcome"));
		assertEquals(2, strings.getItemCount());
		assertFalse(strings.contains("Welcome"));
		assertTrue(strings.contains("Wilkommen"));
		assertTrue(strings.contains("Bienvenue"));
		assertFalse(strings.remove("Welcome"));

		assertTrue(strings.remove("Bienvenue"));
		assertFalse(strings.contains("Bienvenue"));
		assertEquals(1, strings.getItemCount());

		assertTrue(strings.remove("Wilkommen"));
		assertFalse(strings.contains("Wilkommen"));
		assertEquals(0, strings.getItemCount());
	}

	@Test
	public void testCapacityRemoveIndx() {
		IStringSequence strings = new StringSequence();

		for (int i = 0; i < StringSequence.DEFAULT_CAPACITY; i++) {
			assertTrue(strings.add("String_" + i));
		}

		if (strings instanceof sequence.dynamic.StringSequence || strings instanceof sequence.linkedlist.StringSequence ) {
			assertTrue(strings.add("OneMore"));
			assertTrue(strings.remove("OneMore"));
		} else {
			assertFalse(strings.add("OneMore"));

		}

		while (strings.getItemCount() > 0) {
			final int randomIndex = RAND.nextInt(strings.getItemCount());
			strings.remove(randomIndex);
		}
	}

}
