package com.base.array.vs.object;

public class ArrayVsObject {
	public void showData(){
		System.out.println("hi");
	}
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		int[] a = new int[5];
		System.out.println(a.hashCode());
		System.out.println(a.getClass().getCanonicalName());
		Class c =ArrayVsObject.class;
		ClassLoader cl = c.getClassLoader().getParent();
		Class claz = cl.loadClass("com.base.array.vs.object.ArrayVsObject");
		ArrayVsObject aob = (ArrayVsObject) claz.newInstance();
		aob.showData();
	}
}
