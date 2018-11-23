package com.nitesh.algos.large.nums;

public class EfficientExponentiation {

	public static long pow(long x, int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return x;
		if (isEven(n))
			return pow(x * x, n / 2);
		else
			return pow(x * x, n / 2) * x;
	}

	public static boolean isEven(long n) {
		return n % 2 == 0;
	}
}
