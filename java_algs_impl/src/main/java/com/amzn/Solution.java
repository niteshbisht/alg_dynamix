package com.amzn;

//IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Collectors;
//SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
//DEFINE ANY CLASS AND METHOD NEEDED
//CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution
{        
	public static void main(String[] args) {
		List resp = cellCompete(new int[] {1,0,0,0,0,1,0, 0}, 1);
		System.out.println(resp);
	}
// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
 public static List<Integer> cellCompete(int[] states, int days)
 {
 // WRITE YOUR CODE HERE
     for(int i=0;i<days;i++){
         for(int q=0;q<states.length;q++){
             if(q==0){
                 if(states[1]==0){
                     states[0]=0;
                 }else{
                     states[0]=1; //leave as it is
                 }
                 continue;
             }
             if(q!=0 && q==states.length-1){
                 if(states[states.length-2]==0){
                     states[states.length-1]=0;// && states[states.length-1];
                 }else{
                     states[states.length-1]=1;
                     //q[0]=0; leave as it is
                 }
                 continue;
             }
         
             if(q>0 && q<states.length-1){
                 if((states[q-1]==0 && states[q+1]==0) || (states[q-1]==1 && states[q+1]==1)){
                     states[q]=0;
                 }else{
                     states[q]=1;
                 }
             }
         }
     }
     List<Integer> response = Arrays.stream(states).boxed().collect(Collectors.toList());
     return response;   
 }
// METHOD SIGNATURE ENDS
}
