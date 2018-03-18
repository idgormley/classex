package edu.metrostate.ics240.ex7;

import static org.junit.Assert.*;

import org.junit.Test;

public class BracketMatcherTest {

	@Test
	public void testParens() {
		
		assertTrue(BracketMatcher.isValid("()"));
		assertFalse(BracketMatcher.isValid(")("));
		assertFalse(BracketMatcher.isValid(")"));
		assertFalse(BracketMatcher.isValid("("));
	}
	
	@Test
	public void testMisc() {
		
		assertTrue(BracketMatcher.isValid("({[]c}b[a(a)({[]})])"));
		assertTrue(BracketMatcher.isValid("(()())"));
		assertFalse(BracketMatcher.isValid("()))[]{"));
		assertFalse(BracketMatcher.isValid("(([)(]))"));
	}

	@Test
	public void testEmpty(){
		assertTrue(BracketMatcher.isValid(""));
	}
}
