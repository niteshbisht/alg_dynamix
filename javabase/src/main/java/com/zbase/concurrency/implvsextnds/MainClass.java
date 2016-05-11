package com.zbase.concurrency.implvsextnds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class MainClass {
	public static void main(String[] args) {
		/*
		 * int[] p = new int[12]; List<Integer> li = new ArrayList<Integer>();
		 * li.addAll(li); li.indexOf(2); Set<Integer> liset = new
		 * TreeSet<Integer>();
		 */

		String p = "22|Data Structures|45\n" + "23|English|52\n"
				+ "22|English|51\n" + "26|Data Structures|72\n"
				+ "23|Data Structures|61\n" + "21|English|81";
		StringTokenizer token = new StringTokenizer(p, "\n");
		List<String> data = new ArrayList<String>();
		while (token.hasMoreTokens()) {
			String inputData = token.nextToken();
			data.add(inputData);
		}

		Map<String, Integer> result = processData(data);
		System.out.println(result);
	}

	public static Map<String, Integer> processData(List<String> inputData) {
		Map<String, Integer> dataMap = new HashMap<>();
		Map<String, Integer> resultDataMap = new HashMap<>();

		for (String subjectStr : inputData) {
			StringTokenizer tck = new StringTokenizer(subjectStr, "|");
			String[] tokenizedString = subjectStr.split("\\|");
			int studentId = Integer.parseInt(tokenizedString[0]);
			String subjectDetail = tokenizedString[1];
			int marks = Integer.parseInt(tokenizedString[2]);
			if (!dataMap.containsKey(subjectDetail)) {
				dataMap.put(subjectDetail, studentId);
				resultDataMap.put(subjectDetail, marks);
			} else {
				Integer oldStudentId = dataMap.get(subjectDetail);
				if (oldStudentId > studentId) {
					resultDataMap.replace(subjectDetail, marks);
					dataMap.replace(subjectDetail, studentId);
				}
			}
		}

		return resultDataMap;

	}
}
