package com.base.string.tokenizrdem;

import java.util.Stack;
import java.util.StringTokenizer;

public class StringToknizr {
	public Stack<String> stringToknizrDem(String input){
		StringTokenizer strtkn = new StringTokenizer(input, ",");
		Stack<String> stack = new Stack<String>();
		while(strtkn.hasMoreTokens()){
			stack.push(strtkn.nextToken());
		}
		return stack;
	}
}
