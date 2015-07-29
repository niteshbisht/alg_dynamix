package com.design.pattern.template;

public class IntranetBot extends RoboTemplate {

	String name;

	/**
	 * @param name
	 */
	public IntranetBot(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void start() {
		System.out.println("i am Intrarobo start()");
	}

	public void stop() {
		System.out.println("i am Intrarobo stop()");
	}

	public void getParts() {
		System.out.println("i am Intrarobo getParts()");
	}
	
	public boolean testHook(){
		return false;
	}
}
