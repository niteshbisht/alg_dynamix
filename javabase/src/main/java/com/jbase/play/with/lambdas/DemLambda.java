package com.jbase.play.with.lambdas;

import java.util.Arrays;

public class DemLambda {

	public String[] sortStrs(String[] input) {
		Arrays.sort(input, String::compareToIgnoreCase);
		return input;
	}
}
