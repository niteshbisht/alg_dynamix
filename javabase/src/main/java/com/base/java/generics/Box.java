package com.base.java.generics;

public class Box<T> {
	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
	public  <Z extends Number> void inspect(Z z){
		System.out.println(z.getClass().getName());
		System.out.println(t.getClass().getName());
	}
	
	public static void main(String[] args) {
		Box<Integer> integerBox = new Box<Integer>();
		integerBox.setT(new Integer(5));
		integerBox.inspect(new Integer(7));
	}
}
