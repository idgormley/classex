package edu.metrostate.ics240.p2.test;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.metrostate.ics240.p2.towers.Towers;

public class TowersTest {

	@Test
	public void testInital() {
		Towers tow=new Towers();
		assertEquals(5,tow.getRingCount(1));
		System.out.println(tow.move(1, 2));
		assertEquals(4,tow.getRingCount(1));
		assertEquals(1,tow.getRingCount(2));
	}

}
