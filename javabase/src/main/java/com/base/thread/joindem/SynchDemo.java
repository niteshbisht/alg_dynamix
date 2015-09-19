package com.base.thread.joindem;

public class SynchDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Callme target = new Callme();
		Caller ob1 = new Caller(target, "Hello");
		Caller ob2 = new Caller(target, "Synchronized");
		Caller ob3 = new Caller(target, "World");
		// wait for threads to end
		try {
			ob1.t.join();
			ob2.t.join();
			ob3.t.join();
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
		}
	}

}

// This program uses a synchronized block.
class Callme {
	void call(String msg) {
		System.out.println("[" + msg);
		try {
			for (int i = 0; i < 100; i++) {
				Thread.sleep(100);
				System.out.println("i = " + i);
			}
			System.out.println("notifying");
			this.notify();
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
		}
		System.out.println("]");
	}
}

class Caller implements Runnable {
	String msg;
	Callme target;
	Thread t;

	public Caller(Callme targ, String s) {
		target = targ;
		msg = s;
		t = new Thread(this);
		t.start();
	}

	// synchronize calls to call()
	public void run() {
		synchronized (target) { // synchronized block
			target.call(msg);
		}
	}
}
