package com.nitesh.reverse.ptrar;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlaywithPointersTest {

	//@Test
	public void testPlayWithPointers() {
		PlaywithPointers ppt=new PlaywithPointers();
		CharPtr m =ppt.playPointers("Hello");
		
		String resultstr=ppt.viewChars(m);
		assertEquals("Hello", resultstr);
		
	}
	
	//@Test
	public void testPlayWithPointersReversal() {
		PlaywithPointers ppt=new PlaywithPointers();
		CharPtr m =ppt.playPointers("IOU");
		
		CharPtr p=ppt.reverseObject(m);
		CharPtr n=ppt.recurseReversal(p, null);
		String resultstri=ppt.viewChars(n);
		System.out.println(resultstri);
		String resultstr=ppt.viewChars(p);
		assertEquals("UOI", resultstr);
		ArrayList<Integer> p2 = new ArrayList<>();
		LinkedList<Integer> p3=new LinkedList<>();
	}
}
