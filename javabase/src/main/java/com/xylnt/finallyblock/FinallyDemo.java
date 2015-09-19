package com.xylnt.finallyblock;

public class FinallyDemo {
	
	public int showFinalExample() {
		try {
			return 0;
		} catch (Exception e) {
			
		} finally {
			try {

			} finally {
				System.out.println("I am 2");
			}
			System.out.println("IAM 1");
		}
		return 1;
	}

	public static void main(String[] args) {
	}
}
