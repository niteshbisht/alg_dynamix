package com.nitesh.alg.maxsubarray;

public class MaxSubArrayBruteForce {

	class SubArrayResult {
		int low;
		int high;
		int sum;
	}

	public SubArrayResult findMaxSubArraySolution(int[] A) {
		SubArrayResult sres = new SubArrayResult();
		sres.sum = Integer.MIN_VALUE;

		int k = 2;
		int sum = 0;
		int i = 0;
		for (k = 2; k <= A.length - 1; k++)
			for (int p = 0; p < A.length; p++) {
				for (i = 0; i < k; i++) {
					if (!(p + i > A.length - 1))
						sum = sum + A[p + i];
				}
				if (sum > sres.sum) {
					sres.sum = sum;
					sres.low = p;
					sres.high = p + i - 1;
				}
				sum = 0;
			}
		return sres;
	}
}
