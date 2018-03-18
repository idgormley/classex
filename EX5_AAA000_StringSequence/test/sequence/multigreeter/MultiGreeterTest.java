package sequence.multigreeter;

import static org.junit.Assert.*;

import org.junit.Test;

public class MultiGreeterTest {

	@Test
	public void testIntial() {
		MultiGreeter mg = new MultiGreeter(8);
		assertNotNull(mg);
		assertEquals(8, mg.getMaxGreetings());
		assertEquals(0, mg.getNumGreetings());
	}

	@Test
	public void testAddGreeting() {
		MultiGreeter mg = new MultiGreeter(3);
		mg.add("Ni hao");
		assertEquals(1, mg.getNumGreetings());
	}

	@Test
	public void testGreet() {
		MultiGreeter mg = new MultiGreeter(3);
		assertEquals("Hello, World!", mg.greet(MultiGreeter.DEFAULT_NAME));
		assertEquals("Hello, World!", mg.greet());

		mg = new MultiGreeter(3);
		mg.add("Ni hao");
		mg.add("Aloha");
		mg.add("Nyob zoo");
		
		for (int i = 0; i < 1; i++) {
			assertEquals("Ni hao, World!", mg.greet());
			assertEquals("Aloha, World!", mg.greet());
			assertEquals("Nyob zoo, World!", mg.greet());
		}

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
