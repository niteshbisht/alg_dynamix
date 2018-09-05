package com.nitesh.algos.large.nums;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	static long cal(long b, long p, long div) {
		long k = 1, l = b;
		while (p > 0) {
			if ((p & 1) > 0) {  // do bitwise and with 1 to calculate modulus value for prime
				k = (k * l) % div; // keep on doing modulus by multiplying power with k=1 k=> (1*base)% 10000007
			}
			l = (l * l) % div;  // reduced_base = (base*base)% moduluseval
			p = p / 2;   // when this results to a even line 14 is not executed and mod is not updated like for 10 to power values 
			//we don't need to capture a modulus for base values inn power
		}
		return k;
	}

	// Complete the solve function below.
	static long solve(String a, String b) {
		List<Integer> numA = getNumList(a);
		List<Integer> numB = getNumList(b);
		long res = 0, div = 1000000007, div2;
		long base = 0, power = 0;

		for (int i = 0; i < numA.size(); i++) {
			base = ((base * 10) + numA.get(i)) % div;  // finding unit modulus
		}
		div2 = div - 1; // A^p-1 ≡ 1 % p  since 1000000007 is a prime and is our p here 
		for (int i = 0; i < numB.size(); i++) {
			power = ((power * 10) + numB.get(i)) % div2;  // A^p-1 ≡ 1 % p  since 1000000007 this is power line A^p
		}

		if (power == 0) {

		} else {
			res = cal(base, power, div);  // this problem is solved in bottom up approach 
		 				//breaking down divisor and exponents and base using rules of mathematics which precalculates the power and exponents for us
			System.out.println(res);
		}
		return res;
	}

	static LinkedList<Integer> getNumList(String num) {
		LinkedList<Integer> result = new LinkedList<>();
		for (int p = 0; p < num.length(); p++) {
			result.add(Integer.valueOf(String.valueOf(num.charAt(p))));
		}
		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		/*
		 * BufferedWriter bufferedWriter = new BufferedWriter(new
		 * FileWriter(System.getenv("OUTPUT_PATH"))); String input = "5\r\n" + "3 2\r\n"
		 * + "4 5\r\n" + "7 4\r\n" +
		 * "34534985349875439875439875349875 93475349759384754395743975349573495\r\n" +
		 * "34543987529435983745230948023948 3498573497543987543985743989120393097595572309482304"
		 * ;
		 */

		// int result = solve("34534985349875439875439875349875",
		// "93475349759384754395743975349573495");
		long res2 = solve("4", "5");
		/*
		 * int t = scanner.nextInt(); scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		 */

		/*
		 * for (int tItr = 0; tItr < t; tItr++) { String[] ab =
		 * scanner.nextLine().split(" ");
		 * 
		 * String a = ab[0];
		 * 
		 * String b = ab[1];
		 * 
		 * int result = solve(a, b);
		 * 
		 * bufferedWriter.write(String.valueOf(result)); bufferedWriter.newLine(); }
		 */

		/*
		 * bufferedWriter.close();
		 * 
		 * scanner.close();
		 */
	}
}
