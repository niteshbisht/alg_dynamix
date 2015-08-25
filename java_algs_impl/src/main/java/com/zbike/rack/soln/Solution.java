package com.zbike.rack.soln;

public class Solution {
	public int solution(int[] A) {
		int len = A.length;
		int[] b = new int[len];
		int j = 0;
		for (int i = 0; i < len; i++) {
			if (A[i] >= 0) {
				b[j] = i;
				++j;
			}
		}

		int diff = 0;
		int olddiff = 0;
		for (int p = 0; p <= j - 1; p++) {
			if ((p + 1) < j) {
				diff = (b[p + 1] - b[p]) / 2;
				if(diff==1 && olddiff<1)
					olddiff=0;
				if (diff > olddiff) {
					olddiff = diff;
				}
			}
		}

		return diff;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] A = { 1, -1, -1, -1, 1, 1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1,
				-1, -1, -1, 1 };
		int[] p = {10, 0, 8, 2, -1, 12, 11, 3};
		int result = s.solution(A);
		System.out.println(result);
	}
}
