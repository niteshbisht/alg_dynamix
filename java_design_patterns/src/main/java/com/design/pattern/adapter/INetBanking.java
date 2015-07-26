package com.design.pattern.adapter;

public interface INetBanking {
	public void setCustomerId(Integer custId);

	public Integer getCustId();

	public void setCustId(Integer custId);

	public void setFirstName(String firstName);

	public void setLastName(String lastName);

	public String getFirstName();

	public String getLastName();
}
