package com.zbase.throwsexcdiff;

public class MyClaz implements ChildIfaceTwo {

	@Override
	public void methdodThr(int[] arY) throws ClassCastException {
		System.out.println("I am printed");
	}

	public static void main(String[] args) {
		BaseIface bfi = new MyClaz();
		ChildIfaceTwo cf=(ChildIfaceTwo)bfi;
		bfi.methdodThr(new int[]{1,2,5});
		cf.methdodThr(new int[]{1,2,5});
		MyClazVer2 v2 = (MyClazVer2) cf;
		v2.methdodThr(new int[]{1,2,5});
	}
}
