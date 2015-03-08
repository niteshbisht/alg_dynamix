/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nitesh.jcollection.benchmarks;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author nitesh
 */
public class ListBenchMarksTest {
    ListBenchMarks lbnc;
    @Before
    public void setUp(){
        lbnc = new ListBenchMarks();
    }
    
    @Test
    public void test_listBenchMark(){
       lbnc.listBenchMark();
    }
}
