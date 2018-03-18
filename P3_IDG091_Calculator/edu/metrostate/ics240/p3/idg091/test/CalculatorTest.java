package edu.metrostate.ics240.p3.idg091.test;

import static org.junit.Assert.*;

import org.junit.Test;
import edu.metrostate.ics240.p3.idg091.calc.Calculator;

public class CalculatorTest {

	@Test
	public void sizeTest() {
		Calculator test = new Calculator();
		assertTrue(test.isEmpty());
		test.enter("2.0");
		assertEquals(1, test.size());
		test.enter("3.0");
		assertEquals(2, test.size());
		test.clear();
		assertTrue(test.isEmpty());
	}

	public void addTest() {
		Calculator test = new Calculator();
		assertTrue(test.isEmpty());
		test.enter("3.0");
		assertEquals(3.0, test.peek(), .01);
		test.enter("2.0");
		assertEquals(2.0, test.peek(), .01);
		test.enter("+");
		assertEquals(5.0, test.pop(), .01);
		assertTrue(test.isEmpty());
	}

	public void minusTest() {
		Calculator test = new Calculator();
		assertTrue(test.isEmpty());
		test.enter("3.0");
		assertEquals(3.0, test.peek(), .01);
		test.enter("2.0");
		assertEquals(2.0, test.peek(), .01);
		test.enter("-");
		assertEquals(1.0, test.pop(), .01);
		assertTrue(test.isEmpty());
	}

	public void multiplyTest() {
		Calculator test = new Calculator();
		assertTrue(test.isEmpty());
		test.enter("3.0");
		assertEquals(3.0, test.peek(), .01);
		test.enter("2.0");
		assertEquals(2.0, test.peek(), .01);
		test.enter("*");
		assertEquals(6.0, test.pop(), .01);
		assertTrue(test.isEmpty());
	}

	public void divideTest() {
		Calculator test = new Calculator();
		assertTrue(test.isEmpty());
		test.enter("4.0");
		assertEquals(3.0, test.peek(), .01);
		test.enter("2.0");
		assertEquals(2.0, test.peek(), .01);
		test.enter("/");
		assertEquals(2.0, test.pop(), .01);
		assertTrue(test.isEmpty());
	}
}
