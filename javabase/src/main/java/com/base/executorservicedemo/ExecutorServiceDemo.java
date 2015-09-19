package com.base.executorservicedemo;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceDemo {

	public static void main(String[] args) {
		ScheduledExecutorService sc = Executors.newScheduledThreadPool(4);
		BThread bt1 = new BThread("ONE", 1000);
		BThread bt2 = new BThread("TWO", 10000);
		sc.scheduleAtFixedRate(bt1, 2, 3, TimeUnit.SECONDS);
		sc.scheduleAtFixedRate(bt2, 3, 3, TimeUnit.SECONDS);

	}

}


class BThread implements Runnable{

	String threadName;
	int sleepInterval;
	
	/**
	 * @param threadName
	 * @param sleepInterval
	 */
	public BThread(String threadName, int sleepInterval) {
		super();
		this.threadName = threadName;
		this.sleepInterval = sleepInterval;
	}

	@Override
	public void run() {
		System.out.println("Thread_ : "+this.threadName+ " SleepInterval : "+this.sleepInterval);
		long t1 = System.currentTimeMillis();
		try {
			Thread.currentThread().sleep(this.sleepInterval);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Awaiting completion : "+this.threadName+" interval : "+(System.currentTimeMillis()-t1));
	}
	
}