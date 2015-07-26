package com.design.pattern.singleton;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

public class OneInstanceTest {
	OneInstance ou;
	
	@Test
	public void testGetOneInstance(){
		Thread t1 = new Thread(new Runnable() {	
			@Override
			public void run() {
				ou = OneInstance.getOneInstance();
				System.out.println("t1 "+ou.hashCode());
			}
		});
		
		Thread t2 = new Thread(new Runnable() {	
			@Override
			public void run() {
				ou = OneInstance.getOneInstance();
				System.out.println("t2 "+ou.hashCode());
			}
		});
		
		Thread t3 = new Thread(new Runnable() {	
			@Override
			public void run() {
				ou = OneInstance.getOneInstance();
				System.out.println("t3 "+ou.hashCode());
			}
		});
		
		ExecutorService ex = Executors.newFixedThreadPool(3);
		Future f1 = ex.submit(t1);
		Future f2 = ex.submit(t2);
		Future f3 = ex.submit(t3);
		try {
			f1.get();
			f2.get();
			f3.get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
