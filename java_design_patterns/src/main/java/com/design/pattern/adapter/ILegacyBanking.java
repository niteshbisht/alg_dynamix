package com.design.pattern.adapter;

public interface ILegacyBanking {
	public void setName(String name);

	public void setAccountNumber(Integer accountNumber);

	public String getName();

	public Integer getAccountNumber();
}
