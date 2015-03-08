/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nitesh.jcollection.benchmarks;

import java.util.Arrays;

/**
 *
 * @author nitesh
 */
public class ArrayBenchMark {
    public void arraySort(){
        int[] p = {12,2,3,9,1,7,20};
        long l1= System.nanoTime();
        Arrays.sort(p);
        System.out.println(System.nanoTime()-l1);
        System.out.println(p);
    }
}
