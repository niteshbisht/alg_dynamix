package com.base.java.generics;

import org.junit.Assert;
import org.junit.Test;

public class OrderedPairTest {

	@Test
	public void testOrderedPair() {
		Integer ie = new Integer(5);
		OrderedPairE<Integer, String> oe = new OrderedPairE<Integer, String>(
				ie, "five");
		Assert.assertTrue(ie == oe.getKey());
	}

	@Test
	public void testUtil() {
		Pair<Integer, String> p1 = new OrderedPairE<>(1, "apple");
		Pair<Integer, String> p2 = new OrderedPairE<>(2, "pear");
		boolean same = Util.<Integer, String> compare(p1, p2);
		boolean same2 = Util.compare(p1, p2); // This feature, known as type
												// inference, allows you to
												// invoke a generic method as an
												// ordinary method, without
												// specifying a type between
												// angle brackets
		Assert.assertFalse(same);
		Assert.assertFalse(same2);
	}
}
