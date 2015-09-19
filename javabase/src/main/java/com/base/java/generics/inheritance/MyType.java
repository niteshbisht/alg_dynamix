package com.base.java.generics.inheritance;

import java.util.ArrayList;
import java.util.List;

public class MyType<T> {
	List a = new ArrayList();
	public void add(T t){
		a.add(t);
	}
	
	public void addToBox(MyType<Number> mt){
		a.add(mt);
	}
	public static void main(String[] args) {
		MyType<Number> mt = new MyType<Number>();
		mt.add(new Integer(4));
		mt.add(new Double(12));
		mt.addToBox(mt);
		MyType<Integer> mt2 = new MyType<Integer>();
	//	mt.addToBox(mt2); // error
		
	}
}
