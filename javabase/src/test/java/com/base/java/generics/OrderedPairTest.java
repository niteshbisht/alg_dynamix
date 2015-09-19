package com.base.java.generics;

import org.junit.Assert;
import org.junit.Test;

public class OrderedPairTest {

	@Test
	public void testOrderedPair() {
		Integer ie = new Integer(5);
		OrderedPairE<Integer, String> oe = new OrderedPairE<Integer, String>(ie, "five");
		Assert.assertTrue(ie == oe.getKey());
	}
	
	@Test
	public void testUtil(){
		Pair<Integer, String> p1 = new OrderedPairE<>(1, "apple");
		Pair<Integer, String> p2 = new OrderedPairE<>(2, "pear");
		boolean same = Util.<Integer, String>compare(p1, p2);
		Assert.assertFalse(same);
	}
}
