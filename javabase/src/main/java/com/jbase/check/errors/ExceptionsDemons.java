package com.jbase.check.errors;

public class ExceptionsDemons {

	public static void main(String[] args) {
		
		ExceptionsDemons ob = new ExceptionsDemons();
		int val = ob.getException();
		System.out.println(val);
	}

	public int getException() {
		int a=5,p;
		
		try{
			p=5/0;
		}catch(Exception e) {
			System.out.println("I am Exception");
			throw new ArithmeticException();
		}finally{
			System.out.println("One");
			return 0;
		}
	}
}
