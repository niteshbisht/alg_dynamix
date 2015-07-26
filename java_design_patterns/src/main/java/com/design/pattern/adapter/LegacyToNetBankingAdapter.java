package com.design.pattern.adapter;

import java.util.TreeMap;

public class LegacyToNetBankingAdapter implements INetBanking {
	private LegacyBanking legacyBanking;
	private Integer custId;
	private String firstName;
	private String lastName;
	private TreeMap<Integer, Integer> tmap;

	/**
	 * @param legacyBanking
	 */
	public LegacyToNetBankingAdapter(LegacyBanking legacyBanking, Integer custId) {
		super();
		this.legacyBanking = legacyBanking;
		this.firstName = this.legacyBanking.getName().split(" ")[0];
		this.lastName = this.legacyBanking.getName().split(" ")[1];
		this.custId = custId;
		this.tmap = new TreeMap<Integer, Integer>();
		this.tmap.put(this.custId, this.legacyBanking.getAccountNumber());
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	@Override
	public void setCustomerId(Integer custId) {
		this.custId = custId;
	}

	@Override
	public Integer getCustId() {
		return this.custId;
	}
}