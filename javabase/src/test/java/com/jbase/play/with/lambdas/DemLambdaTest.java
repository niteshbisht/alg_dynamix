package com.jbase.play.with.lambdas;

import org.junit.Assert;
import org.junit.Test;

public class DemLambdaTest {
	@SuppressWarnings("deprecation")
	@Test
	public void testSortStrs(){
		DemLambda dm = new DemLambda();
		String[] result = dm.sortStrs(new String[]{"B","Z","M","F"});
		Assert.assertEquals("Matches", new String[]{"B","F","M","Z"}, result);
	}
}
