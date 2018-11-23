package com.nitesh.algos.search;

import org.junit.BeforeClass;
import org.junit.Test;

public class SearchInRotatedArrayTest {

    private static SearchInRotatedArray searchInRotatedArray;

    @BeforeClass
    public static void setUp() {
        searchInRotatedArray = new SearchInRotatedArray();
    }

    @Test
    public void testSolve() {
        this.searchInRotatedArray.solve(new int[]{12, 14, 16, 17, 19, 0, 1, 3, 5, 7, 9, 11}, 16);
    }
}
