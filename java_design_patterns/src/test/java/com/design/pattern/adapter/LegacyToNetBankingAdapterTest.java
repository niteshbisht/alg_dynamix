package com.design.pattern.adapter;

import org.junit.Assert;
import org.junit.Test;

public class LegacyToNetBankingAdapterTest {
	
	@Test
	public void testLegacyWithNetBank(){
		LegacyBanking lbs = new LegacyBanking();
		lbs.setAccountNumber(12152);
		lbs.setName("alchemy roosevelt");
		LegacyToNetBankingAdapter lbtnbadpt = new LegacyToNetBankingAdapter(lbs, 16213);
		Assert.assertTrue("matches first name is valid", lbtnbadpt.getFirstName().equals("alchemy"));
		Assert.assertTrue("matches last name is valid", lbtnbadpt.getLastName().equals("roosevelt"));
	}
}
