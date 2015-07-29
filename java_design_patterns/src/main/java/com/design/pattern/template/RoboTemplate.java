package com.design.pattern.template;

public abstract class RoboTemplate {

	public final void goDoWork() {
		start();
		getParts();
		stop();
		if(testHook()){
			showHookData();
		}
	}

	public void start() {
		System.out.println("i am basic start()");
	}

	public void stop() {
		System.out.println("i am basic stop()");
	}

	public void getParts() {
		System.out.println("i am basic getParts()");
	}
	
	public boolean testHook(){
		return true;
	}
	
	public void showHookData(){
		System.out.println("Umm... I am hooked here...");
	}
}
