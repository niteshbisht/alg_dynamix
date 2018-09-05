package com.nitesh.algos.large.nums;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	static long cal(long b, long p, long div) {
		long k = 1, l = b;
		while (p > 0) {
			if ((p & 1) > 0) { // do bitwise and with 1 to calculate modulus value for prime
				k = (k * l) % div; // keep on doing modulus by multiplying power with k=1 k=> (1*base)% 10000007
			}
			l = (l * l) % div; // reduced_base = (base*base)% moduluseval
			p = p / 2; // when this results to a even line 14 is not executed and mod is not updated
						// like for 10 to power values
			// we don't need to capture a modulus for base values inn power
		}
		return k;
	}

	// Complete the solve function below.
	static long solve(String a, String b) {
		int[] numA = getNumList(a);
		int[] numB = getNumList(b);
		long res = 0, div = 1000000007, div2;
		long base = 0, power = 0;

		for (int i = 0; i < numA.length; i++) {
			base = ((base * 10) + numA[i]) % div; // finding unit modulus
		}
		div2 = div - 1; // A^p-1 ≡ 1 % p since 1000000007 is a prime and is our p here
		for (int i = 0; i < numB.length; i++) {
			power = ((power * 10) + numB[i]) % div2; // A^p-1 ≡ 1 % p since 1000000007 this is power line A^p
		}

		if (power == 0) {

		} else {
			res = cal(base, power, div); // this problem is solved in bottom up approach
			// breaking down divisor and exponents and base using rules of mathematics which
			// precalculates the power and exponents for us
			System.out.println(res);
		}
		return res;
	}

	static int[] getNumList(String num) {
		int[] arr = new int[num.length()];
		for (int p = 0; p < num.length(); p++) {
			arr[p]= Integer.valueOf(String.valueOf(num.charAt(p)));
		}
		return arr;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		//BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
		

		// FileReader fl = new FileReader(new File("input.txt"));
		File file = new File("E:\\algorithms\\alg_dynamix\\java_algs_impl\\testCase.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;
		while ((st = br.readLine()) != null)
		{
			//System.out.println(st);
			String[] ps = st.split(" ");
			long val = solve(ps[0], ps[1]);
			System.out.println(val);
		}
		
	}

	
	
}
