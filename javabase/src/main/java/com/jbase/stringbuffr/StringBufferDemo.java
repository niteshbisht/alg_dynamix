package com.jbase.stringbuffr;

import java.util.Spliterator;
import java.util.function.Supplier;

public class StringBufferDemo {
	public static void main(String[] args) {
		StringBuffer sbr = new StringBuffer("eeeeefeeee");
		sbr.chars();
	}
}

final class IntStr {
	static int returnInt(Supplier<? extends Spliterator.OfInt> supplier,
			int characteristics, boolean parallel) {
		return 0;
	}
}
