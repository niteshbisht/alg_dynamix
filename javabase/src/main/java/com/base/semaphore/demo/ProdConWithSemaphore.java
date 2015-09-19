package com.base.semaphore.demo;

import java.util.concurrent.Semaphore;

public class ProdConWithSemaphore {

	public static void main(String[] args) {
		Que q = new Que();
		new ConsumerCl(q);
		new ProducerCl(q);
	}
}

class Que {
	int n;
	static Semaphore conSem = new Semaphore(0);
	static Semaphore prodSem = new Semaphore(1);

	void get() {
		try {
			conSem.acquire();
		} catch (InterruptedException ie) {
			System.err.println("Interrupted Exception...");
		}
		System.out.println("got n = " + n);
		prodSem.release();
	}

	void put(int n) {
		try {
			prodSem.acquire();
		} catch (InterruptedException ie) {
			System.err.println("Interrupted Exception...");
		}
		this.n = n;
		System.out.println("Put n : " + n);
		conSem.release();
	}
}

class ProducerCl implements Runnable {

	Que q;

	public ProducerCl(Que q) {
		super();
		this.q = q;
		new Thread(this, "ProducerCl").start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++)
			q.put(i);
	}
}

class ConsumerCl implements Runnable {

	Que q;

	public ConsumerCl(Que q) {
		super();
		this.q = q;
		new Thread(this, "ConsumerCl").start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++)
			q.get();
	}
}