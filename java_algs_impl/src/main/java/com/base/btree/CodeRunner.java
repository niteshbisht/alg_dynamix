package com.base.btree;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CodeRunner {

	public static void main(String[] args) {
		int[] dcArray = { 12, 21, 1, 3, 13, 22, 9, 7 };

		TreeContainer tcl = new TreeContainer();
		for (int i = 0; i < dcArray.length; i++) {
			Node n = new Node();
			n.data = dcArray[i];
			tcl.insertNode(n);
		}
		
		ObjectMapper om = new ObjectMapper();
		try {
			System.out.println(om.writeValueAsString(tcl.getBase()));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
