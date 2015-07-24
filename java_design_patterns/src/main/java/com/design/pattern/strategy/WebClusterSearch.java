package com.design.pattern.strategy;

public class WebClusterSearch implements ISearch {

	@Override
	public String[] search(String searchWord) {
		char[] p = searchWord.toCharArray();
		String[] result = new String[p.length];
		int i = 0;
		while (i < p.length) {
			result[i] = p[i] + " " + i;
			i++;
		}
		return result;
	}

}
