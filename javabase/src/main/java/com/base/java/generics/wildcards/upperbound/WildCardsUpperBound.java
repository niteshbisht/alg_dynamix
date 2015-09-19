package com.base.java.generics.wildcards.upperbound;

import java.util.Arrays;
import java.util.List;

public class WildCardsUpperBound {
	
	public static void printList(List<?> list) {
	    for (Object elem: list)
	        System.out.print(elem + " ");
	    System.out.println();
	}
	
	public static double processList(List<? extends Number> li) {
		double d = 0.0;
		for (Number n : li) {
			d = d + n.doubleValue();
		}
		return d;
	}

	public static void main(String[] args) {
		List<Double> ld = Arrays.asList(1.2, 2.3, 3.5);
		System.out.println("sum = " + processList(ld));
		List<Integer> li = Arrays.asList(1, 2, 3);
		System.out.println("sum = " + processList(li));
		
		List<Integer> li2 = Arrays.asList(1, 2, 3);
		List<String>  ls = Arrays.asList("one", "two", "three");
		printList(li2);
		printList(ls);
	}
}
