package com.design.pattern.observer;

public class RestWeb implements Observer {

	@Override
	public void update(String operation, String record) {

		System.out.println("Rest Web Elast Db changed New Values :" + operation
				+ " , " + record);
	}

}
