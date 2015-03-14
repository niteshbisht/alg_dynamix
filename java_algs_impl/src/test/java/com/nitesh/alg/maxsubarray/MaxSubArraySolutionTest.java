package com.nitesh.alg.maxsubarray;

import org.junit.Test;

import com.nitesh.alg.maxsubarray.MaxSubArraySolution.BundleResult;

public class MaxSubArraySolutionTest {

	@Test
	public void test_findMaxSubArray() {

		MaxSubArraySolution mxsar = new MaxSubArraySolution();
		int[] a = { 2 , -3 , -9 , 7 , 8 , -1, -2, -3 , -8, 9};
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			System.out.print(" a["+i+"] = "+a[i]);
		}
		System.out.println();
		
		int high = a.length - 1;
		int low = 0;
		BundleResult bres = mxsar.findMaxSubarray(a, low, high);
		System.out.print(bres.low + " ");
		System.out.print(bres.high + " ");
		System.out.print(bres.sum);

	}
}
