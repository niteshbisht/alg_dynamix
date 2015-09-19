package com.base.concurrency.utils;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

	public static void main(String[] args) {
		ReentrantLock rel = new ReentrantLock();
		new LockThread(rel, "A");
		new LockThread(rel, "B");
	}

}

class SharedCl {
	static int count;
}

class LockThread implements Runnable {

	ReentrantLock lock;
	String threadName;

	public LockThread(Lock lock, String threadName) {
		super();
		this.lock = (ReentrantLock) lock;
		this.threadName = threadName;
		new Thread(this, this.threadName).start();
	}

	@Override
	public void run() {
		System.out.println("Starting thread " + this.threadName);
		try{
			System.out.println(this.threadName + " is waiting to lock count.");
			lock.lock();
			System.out.println(this.threadName + " is locking count.");
			SharedCl.count++;
			System.out.println(this.threadName + ": " + SharedCl.count);
			System.out.println(this.threadName + " is sleeping.");
			Thread.sleep(1000);
		}catch(Exception e){
			System.out.println(e.getCause());
		}
	}

}
