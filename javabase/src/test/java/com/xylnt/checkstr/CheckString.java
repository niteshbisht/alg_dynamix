package com.xylnt.checkstr;

import junit.framework.Assert;

import org.junit.Test;

import com.xylnt.stringb.StringBClaz;
import com.xylnt.stringc.StringCclaz;

public class CheckString {

	@Test
	public void testStringPool() {
		StringBClaz c1 = new StringBClaz("hi");
		StringCclaz c2 = new StringCclaz("hi");

		Assert.assertEquals(c1.s, c2.s);
		System.out.println(c1.s.hashCode());
		System.out.println(c2.s.hashCode());
		Assert.assertEquals(c1.s.hashCode(), c2.s.hashCode());
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
	}
}
