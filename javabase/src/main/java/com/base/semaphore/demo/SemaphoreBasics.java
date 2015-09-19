package com.base.semaphore.demo;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class SemaphoreBasics {

	public static void main(String[] args) {
		Runnable limitedcall = new Runnable() {
			final Random rand = new Random();
			final Semaphore available = new Semaphore(3);
			int count = 0;

			public void run() {
				int time = rand.nextInt(15);
				int num = count++;
				try {
					available.acquire();
					System.out.println("Executing " + "long- run action for "
							+ time + " secs.. #" + num);
					Thread.sleep(time * 1000);
					System.out.println("Done with # " + num);
					available.release();
				} catch (InterruptedException intEx) {
					intEx.printStackTrace();
				}
			}
		};
		
		for (int i = 0; i < 10; i++)
			new Thread(limitedcall).start();

	}
}
