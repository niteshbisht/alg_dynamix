package com.zbase.concurrency.implvsextnds;

public class MainClass {
	public static void main(String[] args) {
		ImplThread itl = new ImplThread("One");
		itl.start();
		itl.start();
		
		ExtendsThread et = new ExtendsThread();
		
	}
}
