package com.nitesh.algos.large.nums;

import java.util.Arrays;

public class LargeNumUtils {

	public static int[] getStoredIntegersFromString(String a) {
		a = new StringBuilder(a).reverse().toString();
		int[] result = null;
		if(a==null) {
			result = new int[1];
			result[0]=0;
		}else {
			result = new int[a.length()];
			result = a.chars().map(e-> Character.getNumericValue(e)).toArray();
		}
		
		return result;
	}
}
