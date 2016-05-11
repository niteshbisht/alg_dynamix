package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArraysProblem {
	public static void main(String[] args) {
		System.out.println(solveScnenario(new int[]{1,3,4,5,5,8,3,2}, 5));
	}
	
	public static int solveScnenario(int[] inputArray, int k){
		
		HashSet<Integer> dataSet = new HashSet<>();
		//List<Object> list = Arrays.stream(p).boxed().collect(Collectors.toList());
		//IntStream stream = Arrays.stream(p);
		Collections.addAll(dataSet, Arrays.stream(inputArray).boxed().toArray(Integer[]::new));
		
		List<Integer> dataList = new ArrayList<Integer>(dataSet);
		int count = 0;
		for(int i=0,j=i+1;i<dataList.size() && j<dataList.size();){
			int sum = dataList.get(i)+dataList.get(j);
			if(sum==k){
				count++;
			}
			
			if(i<dataList.size() && j == (dataList.size()-1)){
				i++;
				j=i+1;
				continue;
			}
			
			if(j<dataList.size()){
				j++;
			}
		}
		return count;
	}
}
