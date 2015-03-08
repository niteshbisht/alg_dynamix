package com.nitesh.fibnseq;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
 
public class Fibonacci {
    private static long[] value;
 
    public static void main(String args[]) throws InterruptedException {
        int n;
        try {
            n = 20;
        } catch (Exception e) {
            throw new RuntimeException(
                    "Please enter in the form java n number ");
        }
        value = new long[n + 1];
        long start = System.nanoTime();
        System.out.print("Dynamic Programming = " + fibon(n));
        long end = System.nanoTime();
        System.out.println("\t time = " + (end - start) + "ns");
        start = System.nanoTime();
        System.out.print("Sequence = " + Sequence(n));
        end = System.nanoTime();
        System.out.println("\t time = " + (end - start) + "ns");
        start = System.nanoTime();
        //int nThreads = Runtime.getRuntime().availableProcessors();
        int nThreads = 30;
        System.out.print(nThreads);
        ExecutorService executorService = Executors
                .newFixedThreadPool(nThreads);
        int result;
        try {
            result = fibonacciSum(n, executorService);
        } catch (ExecutionException e) {
            throw new RuntimeException("Thread Interuppted ");
        }
        System.out.print(" MultiThreading = " + result);
        end = System.nanoTime();
        System.out.println("\t time = " + (end - start) + "ns");
    }
 
    public static long fibon(int n) {
 
        value[0] = 1;
        value[1] = 1;
        if (n <= 2)
            return 1;
        else if (value[n - 1] != 0)
            return value[n];
 
        for (int j = 2; j <= n; j++) {
            value[j] = fibon(j - 2) + fibon(j - 1);
        }
        return value[n];
    }
 
    public static long Sequence(int n) {
        if (n <= 2)
            return 1;
        else
            return (Sequence(n - 1) + Sequence(n - 2));
 
    }
 
    private static class FibonacciThread implements Runnable {
        int index;
        int result;
        ExecutorService executorService;
 
        public FibonacciThread(int index) {
            this.index = index;
        }
 
        public void run() {
            try {
                this.result = fibonacciSum(index, executorService);
            } catch (Exception e) {
                throw new RuntimeException("Thread interupted");
            }
        }
    }
 
    private static int fibonacciSum(int index, ExecutorService executorService)
            throws InterruptedException, ExecutionException {
        if (index == 1 || index == 2) {
            return 1;
        } else {
             
            FibonacciThread fibonacciThread1 = new FibonacciThread(index - 2);
            fibonacciThread1.executorService=executorService;
            Future<?> future = executorService.submit(fibonacciThread1);
            @SuppressWarnings("unused")
			Object object = future.get();
            int resultPart2 = fibonacciSum(index - 1, executorService);
            int result = fibonacciThread1.result + resultPart2;
            //executorService.shutdown();
            return result;
        }
    }
 
}