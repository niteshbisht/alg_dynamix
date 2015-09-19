package com.implicit.castcheck;

class ImplicitCastCheck {

	public static void main(String[] args) {
		System.out.println(new ImplicitCastCheck().getdoubleval());
	}
	
	double getdoubleval(){
		float f = 12f;
		double d;
		int p=2;
		return d= p++ + ++f;
	}

}
