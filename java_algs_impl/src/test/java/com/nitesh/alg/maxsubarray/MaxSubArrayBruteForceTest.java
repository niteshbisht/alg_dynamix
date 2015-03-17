package com.nitesh.alg.maxsubarray;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class MaxSubArrayBruteForceTest {
	int[] arayl;
	MaxSubArrayBruteForce maxSub;

	/*
	 * private int[] generateArray(int size){ int[] p = new int[size]; return p;
	 * }
	 */

	@Before
	public void setUp() {
		// arayl = generateArray(s);
		arayl = new int[] { -2, 5, -7, 2, 10, -3, 9, -7 , -2, 9};
		maxSub = new MaxSubArrayBruteForce();
	}

	@Test
	public void test_findMaxSubArraySolution() {
		MaxSubArrayBruteForce.SubArrayResult result = maxSub
				.findMaxSubArraySolution(arayl);
		System.out.println("Low = " + result.low);
		System.out.println("High = " + result.high);
		System.out.println("MaxSum = " + result.sum);
	}

}
