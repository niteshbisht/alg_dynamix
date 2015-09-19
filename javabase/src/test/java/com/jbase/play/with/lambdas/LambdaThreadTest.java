package com.jbase.play.with.lambdas;

import org.junit.Test;

public class LambdaThreadTest {
	@Test
	public void testShow(){
		LambdaThread lt = new LambdaThread();
		lt.show(5, "hello w");
	}
}
