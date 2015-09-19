package com.jbase.stringbuildr;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;


public class StringBuilderDemo {

	public static void main(String[] args) {
		/*
		 * StringBuilderDemo sbr = new StringBuilderDemo(); sbr.value = new
		 * char[21]; int p=0; for(int i = 65;i<86;i++,p++){ sbr.value[p]=(char)
		 * i; } System.out.println("Pass ONE"); sbr.count = sbr.value.length;
		 * for(int q=0;q<sbr.value.length;q++){
		 * System.out.printf("%c",sbr.value[q]); System.out.print(','); }
		 * System.out.println(); sbr.reverse();
		 */
		
		/*StringBuilder sbr = new StringBuilder();
		sbr.append("eeeeefffff");
		for (int n = 1; n < 100; n++) {
			System.out.println("For n = "+n);
			for (int j = (n - 1) >> 1; j >= 0; j--) {
				int k = n - j;
				System.out.println("j , k = " + j + " , " + k);
			}
		}*/
		/*String s = "hi";
		System.out.println(s.hashCode());
		s=s+"one";
		System.out.println(s.hashCode());
		s="hi";
		String s2 = new String(s);
		System.out.println(s.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s.hashCode());*/
		
		StringBuilder sbr = new StringBuilder("Oneee");
		OutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream ou = null;
		try {
			ou = new ObjectOutputStream(baos);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Class c = StringBuilder.class;
		try {
			java.lang.reflect.Method m = c.getDeclaredMethod("writeObject", java.io.ObjectOutputStream.class);
			m.setAccessible(true);
			m.invoke(sbr, ou);
		
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	int count;
	char[] value;

	public String reverse() {
		boolean hasSurrogates = false;
		int n = count - 1;
		for (int j = (n - 1) >> 1; j >= 0; j--) {
			int k = n - j;
			char cj = value[j];
			char ck = value[k];
			value[j] = ck;
			value[k] = cj;
			if (Character.isSurrogate(cj) || Character.isSurrogate(ck)) {
				hasSurrogates = true;
			}
			/*
			 * System.out.println("\nPass = "+j+" = "); for(int
			 * q=0;q<value.length;q++){ System.out.printf("%c",value[q]);
			 * System.out.print(','); }
			 */
		}
		if (hasSurrogates) {
			reverseAllValidSurrogatePairs();
		}
		return new String(value);
	}

	/** Outlined helper method for reverse() */
	private void reverseAllValidSurrogatePairs() {
		for (int i = 0; i < count - 1; i++) {
			char c2 = value[i];
			if (Character.isLowSurrogate(c2)) {
				char c1 = value[i + 1];
				if (Character.isHighSurrogate(c1)) {
					value[i++] = c1;
					value[i] = c2;
				}
			}
		}
	}

}
