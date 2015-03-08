/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nitesh.jcollection.benchmarks;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nitesh
 */
public class ListBenchMarks {
    public void listBenchMark(){
        List<Integer> list = new ArrayList<Integer>();
        long l1 = System.nanoTime();
        list.add(5);
        System.out.println(System.nanoTime()-l1);
        
        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(22);
        list2.add(23);
        list2.add(45000);
        
        l1=System.nanoTime();
        list.addAll(list2);
        System.out.println(System.nanoTime()-l1);
        
    }
    
    
}
