package com.base.java.generics;

import org.junit.Assert;
import org.junit.Test;

public class GameTest {
	/*Game g;*/
	
	@Test
	public void testGameGeneric(){
		Game<Integer> gm = new Game<Integer>();
		gm.setElem(5);
		Integer i = gm.getElem();
		Assert.assertTrue(i.intValue() == 5);
	}
}
