/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nitesh.alg.maxsubarray;

/**
 *
 * @author nitesh
 */
public class MaxSubArraySolution {

	class BundleResult {
		int low;
		int high;
		long sum;
	}

	private BundleResult findMaxCrossingSubArray(int[] A, int low, int mid,
			int high) {
		System.out
				.println("Low = " + low + " Mid = " + mid + " High = " + high);
		for (int p = low; p <= high; p++) {
			System.out.print("A[" + p + "] = " + A[p]);
			System.out.print(" | ");
		}
		System.out.println();
		long sum = 0;
		int max_left = 0;
		int max_right = 0;
		long left_sum = Long.MIN_VALUE;
		long right_sum = Long.MIN_VALUE;
		for (int i = mid; i >= low; i--) {
			sum += A[i];
			if (sum > left_sum) {
				left_sum = sum;
				max_left = i;
			}
		}
		sum = 0;
		for (int j = mid + 1; j <= high; j++) {
			sum += A[j];
			if (sum > right_sum) {
				right_sum = sum;
				max_right = j;
			}
		}

		BundleResult bresult = new BundleResult();
		bresult.low = max_left;
		bresult.high = max_right;
		bresult.sum = left_sum + right_sum;
		return bresult;
	}

	public BundleResult findMaxSubarray(int[] a, int low, int high) {
		if (low == high) {
			BundleResult res = new BundleResult();
			res.high = high;
			res.low = low;
			res.sum = a[low];
			return res;
		} else {
			int mid = (int) Math.floor((low + high) / 2);
			BundleResult leftres = new BundleResult();
			leftres = findMaxSubarray(a, low, mid);
			BundleResult rightres = new BundleResult();
			rightres = findMaxSubarray(a, mid + 1, high);
			BundleResult crossres = new BundleResult();
			crossres = findMaxCrossingSubArray(a, low, mid, high);
			if (leftres.sum > rightres.sum && leftres.sum > crossres.sum) {
				return leftres;
			} else if (rightres.sum > leftres.sum
					&& rightres.sum > crossres.sum) {
				return rightres;
			} else {
				return crossres;
			}

		}
	}
}