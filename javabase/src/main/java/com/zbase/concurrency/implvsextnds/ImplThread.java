package com.zbase.concurrency.implvsextnds;

public class ImplThread implements Runnable {

	Thread t;
	
	
	/**
	 * @param t
	 */
	public ImplThread(String name) {
		super();
		this.t = new Thread(this);
	}

	

	@Override
	public void run() {
		System.out.print("HELLO");;
	}
	
	public void start(){
		this.t.start();
	}
}
