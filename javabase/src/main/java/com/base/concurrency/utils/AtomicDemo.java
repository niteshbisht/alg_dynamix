package com.base.concurrency.utils;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {

	public static void main(String[] args) {
		new AtomicThread("A");
		new AtomicThread("B");
		new AtomicThread("C");
	}

}

class Shared {
	static AtomicInteger ai = new AtomicInteger(0);
}

class AtomicThread implements Runnable {

	String name;

	public AtomicThread(String name) {
		this.name = name;
		new Thread(this, this.name).start();
	}

	@Override
	public void run() {

		for (int i = 0; i < 3; i++) {
			System.out.println(this.name + " got value : "
					+ Shared.ai.getAndSet(i));
		}

	}

}