package com.design.pattern.singleton;

public class OneInstance {
	private static OneInstance INSTANCE;
	private static Object lock = new Object();

	private OneInstance() {

	}

	public static OneInstance getOneInstance() {
		if (INSTANCE == null) {
			synchronized (lock) {
				INSTANCE = new OneInstance();
			}
		}
		return INSTANCE;
	}
}
