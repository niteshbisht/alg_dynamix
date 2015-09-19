package com.base.semaphore.demo;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
	public static void main(String[] args) {
		Semaphore sem = new Semaphore(1);
		new IncThread(sem, "A");
		new DecThread(sem, "B");
	}
}

class Shared {
	static int ctr = 0;
}

class IncThread implements Runnable {

	String threadName;
	Semaphore sem;

	public IncThread(Semaphore sem, String threadName) {
		super();
		this.threadName = threadName;
		this.sem = sem;
		new Thread(this).start();
	}

	@Override
	public void run() {
		System.out.println("Starting Thread  " + this.threadName);
		try {
			sem.acquire();
			System.out.println(this.threadName + " gets a permit.");
			// Now, access shared resource.
			for (int i = 0; i < 5; i++) {
				Shared.ctr++;
				System.out.println(this.threadName + " : " + Shared.ctr);
				// Now, allow a context switch -- if possible.
				Thread.sleep(10);
			}
		} catch (Exception e) {
			System.err.println("Exception thrown...");
		}
		// Release the permit.
		System.out.println(this.threadName + " releases the permit.");
		sem.release();
	}
}

// A thread of execution that decrements count.
class DecThread implements Runnable {
	String threadName;
	Semaphore sem;

	DecThread(Semaphore s, String threadName) {
		sem = s;
		this.threadName = threadName;
		new Thread(this).start();
	}

	public void run() {
		System.out.println("Starting " + threadName);
		try {
			// First, get a permit.
			System.out.println(threadName + " is waiting for a permit.");
			sem.acquire();
			System.out.println(threadName + " gets a permit.");
			// Now, access shared resource.
			for (int i = 0; i < 5; i++) {
				Shared.ctr--;
				System.out.println(threadName + ": " + Shared.ctr);
				// Now, allow a context switch -- if possible.
				Thread.sleep(10);
			}
		} catch (InterruptedException exc) {
			System.err.println(exc);
		}
		// Release the permit.
		System.out.println(threadName + " releases the permit.");
		sem.release();
	}
}
