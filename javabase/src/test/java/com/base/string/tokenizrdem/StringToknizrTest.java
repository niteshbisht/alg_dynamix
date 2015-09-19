package com.base.string.tokenizrdem;

import java.util.Arrays;
import java.util.Stack;

import junit.framework.Assert;

import org.junit.Test;

public class StringToknizrTest {
	@Test
	public void testStringToknizrDem(){
		StringToknizr stringToknizr = new StringToknizr();
		Stack<String> result=stringToknizr.stringToknizrDem("I,am,First,Here");
		Object[] objAr = new Object[result.size()];
		result.copyInto(objAr);
		Assert.assertTrue(objAr[0].equals("I"));
		Arrays.sort(objAr);
	}
}
