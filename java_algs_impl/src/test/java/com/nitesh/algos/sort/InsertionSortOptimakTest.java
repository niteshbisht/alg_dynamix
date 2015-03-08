package com.nitesh.algos.sort;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import org.junit.Test;

public class InsertionSortOptimakTest {

	public static void test_fileGenerator(int number) throws IOException{
		File f = new File("src/test/resources/insertionsort.txt");
		if (f.exists())
			f.delete();
		FileWriter fw = new FileWriter(f);
		f.createNewFile();
		Random rn = new Random();
		int range = number - 0 + 1;
		for (int i = number; i > 0; i--) {
			int n = rn.nextInt(range) + 0;
			fw.write(n + ",");
		}
		fw.flush();
	}
	
	@Test
	public void test_doInsertionSort() throws IOException {
		System.out.println("For 100");
		test_fileGenerator(100);
		InsertionSort obj2 = new InsertionSort("insertionsort");
		obj2.doInsertionSort();
		InsertionSortOptimak obj = new InsertionSortOptimak("insertionsort");
		obj.doInsertionSort();
		//  Bench Mark for 1000
		System.out.println("For 1000");
		test_fileGenerator(1000);
		obj2 = new InsertionSort("insertionsort");
		obj2.doInsertionSort();
		obj = new InsertionSortOptimak("insertionsort");
		obj.doInsertionSort();
		
		System.out.println("For 10000");
		test_fileGenerator(10000);
		obj2 = new InsertionSort("insertionsort");
		obj2.doInsertionSort();
		obj = new InsertionSortOptimak("insertionsort");
		obj.doInsertionSort();
		
		System.out.println("For 100000");
		test_fileGenerator(100000);
		obj2 = new InsertionSort("insertionsort");
		obj2.doInsertionSort();
		obj = new InsertionSortOptimak("insertionsort");
		obj.doInsertionSort();
	}

}
