package com.jbase.serialization.dem;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationDem {

	public static void main(String[] args) throws IOException {
		FileOutputStream fo = new FileOutputStream("ser.serila");
		ObjectOutputStream ou = new ObjectOutputStream(fo);
		Serializabl sl = new Serializabl();
		sl.setVal(2);
		ou.writeObject(sl);
	}
}

class Serializabl implements Serializable {
	private int val;
	public void setVal(int val) {
		this.val = val;
	}
	
	public int getVal() {
		return val;
	}
}