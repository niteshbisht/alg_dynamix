package com.nitesh.algos.sort;

import org.junit.Assert;
import org.junit.Test;

public class BubbleSortTest {

  @Test
  public void testSort() {
    BubbleSort obj = new BubbleSort(new int[]{5,3,1,4,9,7});
    int[] sortedArray = obj.sort();
    Assert.assertTrue(sortedArray[1] > sortedArray[0]);
    Assert.assertTrue(sortedArray[sortedArray.length-2] < sortedArray[sortedArray.length-1]);
  }
}
