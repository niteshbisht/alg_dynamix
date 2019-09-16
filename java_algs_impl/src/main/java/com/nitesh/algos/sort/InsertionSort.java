package com.nitesh.algos.sort;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
@Slf4j
public class InsertionSort {

	private volatile int[] array;

	public int[] getArray() {
		return array;
	}

	public InsertionSort(String filename) {
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
			log.error("Error ", e);
		} catch (IOException e) {
			log.error("Error ", e);
		}
	}

	public void doInsertionSort() {
		long t1 = System.nanoTime();
		for (int j = 1; j < array.length; j++) {
			int key = array[j];
			int i = j - 1;
			while (i >= 0 && array[i] > key) {
				array[i + 1] = array[i];
				i = i - 1;
			}
			array[i + 1] = key;
		}
		log.info("BenchMark for Traditional/Trivial Insertion Sort {}"+(System.nanoTime() - t1));
	}
}
