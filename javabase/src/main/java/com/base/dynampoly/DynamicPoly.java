package com.base.dynampoly;

public class DynamicPoly {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*A objA = new B();
		A objB = new C();
		objA.show(4);
		objB.show(88);*/
		if(args.length>0){
			System.out.println("Lenth > 0 ");
		}else{
			System.out.println(" Not "+args.length);
			System.out.println(args.hashCode());
			System.out.println(args.toString().toCharArray());
		}
		
		char c='a';
		System.out.println((int)c);
	}
}

class A {
	void show(int p) {
		System.out.println("In Parent");
	}
}

class B extends A {
	void show(int p) {
		System.out.println(p + " IN B");
	}
}

class C extends A {
	void show(int p) {
		System.out.println(p + " IN C");
	}
}