package com.base.java.generics.bounds;

public class ComparisonUtil {
	// results in error
	/*
	 public static <T> int countGreaterThan(T[] anArray, T elem) { 
	 int count = 0; 
	 for (T e : anArray) 
	 	if (e > elem) // compiler error 
	 	++count; 
	 	return count; 
	 }
	 */

	public static <T extends Comparable<T>> int countGreaterThan(T[] anArray,
			T elem) {
		int count = 0;
		for (T e : anArray)
			if (e.compareTo(elem) > 0) // No compiler error
				++count;
		return count;
	}
}

interface Comparable<T> {
	public int compareTo(T o);
}