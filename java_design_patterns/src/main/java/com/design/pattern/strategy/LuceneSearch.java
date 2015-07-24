package com.design.pattern.strategy;

public class LuceneSearch implements ISearch {

	@Override
	public String[] search(String searchWord) {
		String[] p = new String[10];
		for (int i = 0; i < 10; i++)
			p[i] = searchWord + "" + i;
		return p;
	}

}
