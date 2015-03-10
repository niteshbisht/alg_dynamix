package com.nitesh.alg.maxsubarray;

import org.junit.Test;

import com.nitesh.alg.maxsubarray.MaxSubArraySolution.BundleResult;

public class MaxSubArraySolutionTest {

	@Test
	public void test_findMaxSubArray() {

		MaxSubArraySolution mxsar = new MaxSubArraySolution();
		int[] a = { 15, 12, 11, 10, 8, 2, 3, 6, 8, 9, 10, 11, 13, 12, 16, 14 };
		int sum = 0;
		for (int i = 0; i <= 15; i++) {
			System.out.println(" i : "+i+" Value = a["+i+"]"+a[i]);
		}
		
		int high = a.length - 1;
		int low = 0;
		BundleResult bres = mxsar.findMaxSubarray(a, low, high);
		System.out.print(bres.low + " ");
		System.out.print(bres.high + " ");
		System.out.print(bres.sum);

	}
}
