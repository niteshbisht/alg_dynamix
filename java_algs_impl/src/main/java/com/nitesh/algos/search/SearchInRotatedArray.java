package com.nitesh.algos.search;

public class SearchInRotatedArray {

    public int solve(int[] input, int target) {
        int low = 0, hi = input.length;

        while (low < hi) {
            int mid = (low + hi) / 2;
            double num = (input[mid] < input[0]) == (target < input[0]) ?
                    input[mid] : target < input[0] ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
            if (num < target)
                low = mid + 1;
            else if (num > target)
                hi = mid;
            else
                return mid;
        }
        return -1;
    }

}
