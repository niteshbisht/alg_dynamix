package com.base.java.generics.wildcards.upperbound;

import java.util.ArrayList;
import java.util.List;

/*
 * a lower bounded wildcard restricts the unknown type to be a specific type or a super type of that type.
   A lower bounded wildcard is expressed using the wildcard character ('?'),
   following by the super keyword, followed by its lower bound: <? super A>.*/
//Note: You can specify an upper bound for a wildcard, or you can specify a lower bound, but you cannot specify both.

public class WildCardsLowerBound {
	
	/**
	 * Lower Bound
	 * @param li
	 */
	public static void demoLowerB(List<? super ClazB> li){
		
	}
	
	/**
	 * Upper Bound
	 * @param li
	 */
	public static void demoUpperB(List<? extends ClazB> li){
		
	}
	
	public static void addNumbers(List<? super Integer> list) {
	    for (int i = 3; i <= 13; i++) {
	        list.add(i);
	    }
	}
	
	public static void main(String[] args) {
		List<Integer> nl = new ArrayList<Integer>();
		nl.add(new Integer(2));
		addNumbers(nl);
		for(Number ni : nl){
			System.out.println(ni.doubleValue());
		}
		
		ClazC cl = new ClazC();
		List<ClazC> lis = new ArrayList<ClazC>();
		lis.add(cl);
		
		//demoLowerB(lis); // causes error
		
		// no error for Upper Bound
		demoUpperB(lis);
		
		ClazA clA = new ClazA();
		List<ClazA> lisA = new ArrayList<ClazA>();
		lisA.add(clA);
		demoLowerB(lisA);
		
	}
}
