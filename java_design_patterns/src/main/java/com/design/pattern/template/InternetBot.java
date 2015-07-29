package com.design.pattern.template;

public class InternetBot extends RoboTemplate {
	String name;

	/**
	 * @param name
	 */
	public InternetBot(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public void start() {
		System.out.println("i am Irobo start()");
	}

	public void stop() {
		System.out.println("i am Irobo stop()");
	}

	public void getParts() {
		System.out.println("i am Irobo getParts()");
	}
	
	public boolean testHook(){
		return true;
	}
}
