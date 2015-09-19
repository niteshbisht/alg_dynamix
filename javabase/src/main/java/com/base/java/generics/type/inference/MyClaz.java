package com.base.java.generics.type.inference;

/*static <T> List<T> emptyList();
 Consider the following assignment statement:

 List<String> listOne = Collections.emptyList();*/

/*However, this is not necessary in this context. It was necessary in other contexts, though. Consider the following method:

 void processStringList(List<String> stringList) {
 // process stringList
 }
 Suppose you want to invoke the method processStringList with an empty list. In Java SE 7, the following statement does not compile:

 processStringList(Collections.emptyList());
 The Java SE 7 compiler generates an error message similar to the following:

 List<Object> cannot be converted to List<String>
 The compiler requires a value for the type argument T so it starts with the value Object. Consequently, the invocation of Collections.emptyList returns a value of type List<Object>, which is incompatible with the method processStringList.
 */

// Note: It is important to note that the inference algorithm uses only
// invocation arguments, target types, and possibly an obvious expected return
// type to infer types. The inference algorithm does not use results from later
// in the program.
/*Thus, in Java SE 7, you must specify the value of the value of the type argument as follows:

 processStringList(Collections.<String>emptyList());
 */
/*This is no longer necessary in Java SE 8. The notion of what is a target type has been expanded to include method arguments, such as the argument to the method processStringList. In this case, processStringList requires an argument of type List<String>. The method Collections.emptyList returns a value of List<T>, so using the target type of List<String>, the compiler infers that the type argument T has a value of String. Thus, in Java SE 8, the following statement compiles:

 processStringList(Collections.emptyList());*/

public class MyClaz<X> {

	String s;

	public <T> MyClaz(T t) {
		this.s = (String) t;
	}

	public String getS() {
		return s;
	}

	public static void main(String[] args) {
		MyClaz<Integer> mc = new MyClaz<Integer>("one");
		System.out.println(mc.getS());
	}
}
