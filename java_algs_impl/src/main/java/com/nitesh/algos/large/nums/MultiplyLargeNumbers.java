package com.nitesh.algos.large.nums;

public class MultiplyLargeNumbers {

	static void multiply(String a, String b) {
		int[] numA = LargeNumUtils.getStoredIntegersFromString(a);
		int[] numB = LargeNumUtils.getStoredIntegersFromString(b);

		int[] arr = new int[numA.length + numB.length];

		for (int p = 0; p < numA.length; p++) {
			for (int q = 0; q < numB.length; q++) {
				int num = numA[p] * numB[q];
				arr[p + q] += num;
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < arr.length; i++) {
			int mod = arr[i] % 10;
			int carry = arr[i] / 10;
			if (i + 1 < arr.length) {
				arr[i + 1] += carry;
			}
			sb.insert(0, mod);
		}

		while (sb.charAt(0) == '0' && sb.length() > 1) {
			sb.deleteCharAt(0);
		}
		System.out.println(sb);
	}

	public static void main(String[] args) {
		multiply("102", "26");
	}

}
