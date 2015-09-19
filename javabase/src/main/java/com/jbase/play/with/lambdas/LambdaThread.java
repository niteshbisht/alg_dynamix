package com.jbase.play.with.lambdas;

public class LambdaThread {
	public void show(int count, String text) {
		Runnable r = () -> {
			for (int i = 0; i < count; i++) {
				System.out.println(text);
				Thread.yield();
			}
		};
		new Thread(r).start();
	}
}
