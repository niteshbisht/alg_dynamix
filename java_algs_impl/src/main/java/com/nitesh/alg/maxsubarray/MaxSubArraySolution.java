/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nitesh.alg.maxsubarray;

/**
 *
 * @author nitesh
 */
public class MaxSubArraySolution {
    
    class BundleResult{
        int first;
        int second;
        long third;
    }
    
    public BundleResult findMaxSubArray(int[] A, int low, int mid, int high){
        long sum=0;
        int max_left = 0;
        int max_right = 0;
        long left_sum= Long.MIN_VALUE; 
        long right_sum= Long.MIN_VALUE;
        for (int i = low; i < mid; i++) {
            sum += A[i];
            if(sum>left_sum){
                left_sum= sum;
                max_left = i;
            }
        }
        sum = 0;
        for (int i = mid; i < high; i++) {
            sum += A[i];
            if(sum>right_sum){
                right_sum= sum;
                max_right = i;
            }
        }
        
        BundleResult bresult= new BundleResult();
        bresult.first = max_left;
        bresult.second = max_right;
        bresult.third = left_sum+right_sum;
        return bresult;
    }
    
    
}
