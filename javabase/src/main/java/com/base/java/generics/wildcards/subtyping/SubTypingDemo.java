package com.base.java.generics.wildcards.subtyping;

import java.util.ArrayList;
import java.util.List;

public class SubTypingDemo {

	public void erroNeousSubtyping(){
		B b = new B();
		A a = b;  // possible
		//but
		List<B> lib = new ArrayList<>();
		// List<A> lia = lib;  // compile-time error
		
		List<? extends B> intList = new ArrayList<>();
		List<? extends A>  numList = intList;  // OK. List<? extends B> is a subtype of List<? extends A>
		
	}
}

class A{
	
}

class B extends A{
	
}
