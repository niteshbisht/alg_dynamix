package com.base.concurrency.utils;

import java.util.concurrent.CountDownLatch;

public class CDLDemo {

	public static void main(String[] args) {
		CountDownLatch cdl = new CountDownLatch(100);
		new LatchThread(cdl);

		try {
			while (true) {
				if (cdl.getCount() < 1) {
					System.out.println("Going to Break Now at : "
							+ cdl.getCount());
					break;
				}
			}
			cdl.await();
			System.out.println("calledAwait");
		} catch (InterruptedException e) {
			System.err.println("Interrupted Exception!!!!..");
		}

		System.out.println("DONE");
	}

}

class LatchThread implements Runnable {

	private CountDownLatch latch;

	public LatchThread(CountDownLatch latch) {
		super();
		this.latch = latch;
		new Thread(this).start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(i);
			/*
			 * try { Thread.sleep(1000); } catch (InterruptedException e) { //
			 * TODO Auto-generated catch block e.printStackTrace(); }
			 */
			latch.countDown();
		}
	}

}