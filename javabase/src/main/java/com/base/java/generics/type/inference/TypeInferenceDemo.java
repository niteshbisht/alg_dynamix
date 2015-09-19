package com.base.java.generics.type.inference;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TypeInferenceDemo {
	// Type inference is a Java compiler's ability to look at each method
	// invocation and corresponding declaration to determine the type argument
	// (or arguments) that make the invocation applicable. The inference
	// algorithm determines the types of the arguments and, if available, the
	// type that the result is being assigned, or returned. Finally, the
	// inference algorithm tries to find the most specific type that works with
	// all of the arguments.
	
	static <T> T pick(T a1, T a2) { 
		return a2; 
	}

	public static void main(String[] args) {
		ArrayList<String> l = new ArrayList<String>();
		l.add("A");
		Serializable s = pick("d", l);
		System.out.println(s == l);
		System.out.println("he");
	}
}
