package com.design.pattern.strategy;

public class UtilizeSearchStrategy {
	private ISearch searchStrategy;

	public void setSearchStrategy(ISearch searchStrategy) {
		this.searchStrategy = searchStrategy;
	}

	public Object getSearchResult(String input) {
		return searchStrategy.search(input);
	}
}
