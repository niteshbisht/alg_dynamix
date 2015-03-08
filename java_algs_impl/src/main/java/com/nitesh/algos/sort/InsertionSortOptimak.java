package com.nitesh.algos.sort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import com.nitesh.algos.search.BinarySearchInsertSortCase;

public class InsertionSortOptimak {
	private volatile int[] array;

	public int[] getArray() {
		return array;
	}

	public InsertionSortOptimak(String filename) {
		File f = new File("src/test/resources/" + filename + ".txt");
		String s;
		try {
			BufferedReader bfr = new BufferedReader(new FileReader(f));
			while ((s = bfr.readLine()) != null) {
				String p[] = s.split(",");
				array = new int[p.length];
				for (int i = 0; i < p.length; i++)
					array[i] = Integer.parseInt(p[i]);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doInsertionSort() {
		long t1 = System.nanoTime();
		for (int j = 1; j < array.length; j++) {
			int key = array[j];
			int i = j - 1;
			int rank = BinarySearchInsertSortCase.rank(key,
					Arrays.copyOfRange(array, 0, i + 1));
			if (rank != j) {
				int temp = array[rank];
				array[rank] = key;
				array[rank + 1] = temp;
			}
			// System.out.println("Pass " + j + " the array is -->");
			/*
			 * for(int p=0;p<array.length;p++) System.out.print(array[p]+" ");
			 * System.out.println();
			 */
		}
		for(int p=0;p<array.length;p++) 
			System.out.print(array[p]+" ");
		System.out.println("BenchMark for Optimal Insertion Sort With BinarySearch Use : "+(System.nanoTime() - t1));
	}

}
