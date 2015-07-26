package com.design.pattern.adapter;

public class LegacyBanking implements ILegacyBanking {
	private Integer accountNumber;
	private String name;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Integer getAccountNumber() {
		return accountNumber;
	}

	@Override
	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}
}
