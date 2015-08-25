package com.zbike.rack.soln;

public class SolnTree {
	public static void main(String[] args) {
		Tree t0 = new Tree();
		Tree t0L = new Tree();
		Tree t0R = new Tree();
		Tree t1 = new Tree();
		Tree t2 = new Tree();
		Tree t1L = new Tree();
		Tree t1R = new Tree();
		Tree t2L = new Tree();
		Tree t2R = new Tree();
		Tree t3 = new Tree();
		Tree t4 = new Tree();
		Tree t3L = new Tree();
		Tree t3R = new Tree();
		Tree t4L = new Tree();
		Tree t4R = new Tree();
		Tree t5 = new Tree();
		Tree t6 = new Tree();
		Tree t5L = new Tree();
		Tree t5R = new Tree();
		Tree t6L = new Tree();
		Tree t6R = new Tree();
		Tree t0Lf = new Tree();
		Tree t0Rf = new Tree();
		t0.l = t0L;
		t0.r = t0R;
		t0L.l = t1;
		t0L.r = t0Lf;
		t0R.r = t2;
		t0R.l = t0Rf;
		t1.l = t1L;
		t1.r = t1R;
		t2.l = t2L;
		t2.r = t2R;
		t1L.l = t3;
		t1R.l = t4;
		t3.l = t3L;
		t3.r = t3R;
		t4.l = t4L;
		t4.r = t4R;
		t3L.l = null;
		t3R.r = null;
		t4L.l = t5;
		t4L.r = t6;
		t5.l = t5L;
		t5.r = t5R;
		t6.l = t6L;
		t6.r = t6R;
		t5L.l = null;
		t5L.r = null;
		t6L.l = null;
		t6L.r = null;
		t5R.l = null;
		t5R.r = null;
		t6R.l = null;
		t6R.r = null;

		TreeSolution ts = new TreeSolution();
		int result = ts.solution(t0);
		System.out.println(result);
	}
}

class Tree {
	public int x;
	public Tree l;
	public Tree r;
}

class TreeSolution {
	static int count = 0;

	public int solution(Tree T) {
		// int count=0;
		if (T != null) {
			solution(T.l);
			solution(T.r);

			if (T.l == null && T.r == null) {
				System.out.println(count);
				++count;
			}
		}
		return count;
	}
}