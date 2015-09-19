package com.base.concurrency.utils;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallableDemo {

	public static void main(String[] args) {
		ExecutorService ex = Executors.newFixedThreadPool(3);
		Future<Integer> f1;
		Future<Double> f2;
		Future<Long> f3;
		
		TimeUnit tu = TimeUnit.NANOSECONDS;
		System.out.println(tu.toDays(1000000000));
		System.out.println("Starting  --|");
		int p[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		f1 = ex.submit(new Sum(p));
		System.out.println(f1.isDone());
		f2 = ex.submit(new Hypot(3, 4));
		System.out.println(f2.isDone());
		f3 = ex.submit(new Factorial(20));
		System.out.println(f3.isDone());
		int i = 0;
		while (!(f1.isDone() && f2.isDone() && f3.isDone())) {
			System.out.println("== Iteration i --> "+(i));
			i++;
			System.out.println("f1 = " + f1.isDone());
			System.out.println("f2 = " + f2.isDone());
			System.out.println("f3 = " + f3.isDone());
			System.out.println(" ");
		}

		try {
			System.out.println(f1.get());
			System.out.println(f2.get());
			System.out.println(f3.get());
		} catch (InterruptedException | ExecutionException iex) {
			System.err.println("Exception caught");
		}
		ex.shutdown();
	}

}

class Sum implements Callable<Integer> {

	int a[];

	public Sum(int a[]) {
		super();
		this.a = a;
	}

	@Override
	public Integer call() throws Exception {
		java.lang.Integer sum = 0;
		for (int i = 0; i < this.a.length; i++) {
			Thread.sleep(2000);
			sum = sum + a[i];
		}
		return sum;
	}
}

class Hypot implements Callable<Double> {

	double x, y;

	public Hypot(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public Double call() throws Exception {
		Double hypot;
		hypot = Math.pow(x, 2) + Math.pow(y, 2);
		hypot = Math.sqrt(hypot);
		return hypot;
	}
}

class Factorial implements Callable<Long> {

	int x;

	public Factorial(int x) {
		super();
		this.x = x;
	}

	@Override
	public Long call() throws Exception {
		long fact = 1;
		for (int i = 2; i <= this.x; i++) {
			Thread.sleep(2000);
			fact *= i;
		}
		return fact;
	}
}