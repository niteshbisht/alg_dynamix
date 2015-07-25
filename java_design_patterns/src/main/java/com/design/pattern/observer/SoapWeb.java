package com.design.pattern.observer;

public class SoapWeb implements Observer {

	@Override
	public void update(String operation, String record) {

		System.out.println("SOAP Web Elast Db changed New Values :" + operation
				+ " , " + record);
	}

}
