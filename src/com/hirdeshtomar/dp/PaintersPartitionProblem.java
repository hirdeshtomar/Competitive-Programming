
/*
 * ---Problem Statement---
 * You have to paint N boards of length {A0, A1, A2 … AN-1}. 
 * There are K painters available and you are also given how much time a painter takes to paint 1 unit of board. 
 * You have to get this job done as soon as possible under the constraints that any painter will only paint
 * continuous sections of board, say board {2, 3, 4} or only board {1} or nothing but not board {2, 4, 5}.
 * -----------------------
 *  
 * Recursive Solution
 * 
 * Author - Hirdesh Tomar 
 * Date - 23rd December 2017
 */

package com.hirdeshtomar.dp;

public class PaintersPartitionProblem {

	private static int[] boards = { 100, 200, 300, 400, 500, 600, 700, 800, 900 };
	private static int k = 3;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PaintersPartitionProblem paintTask = new PaintersPartitionProblem();
		System.out.println(paintTask.optCost(boards, boards.length, k));

	}

	public int optCost(int[] A, int n, int k) {

		if (k == 1)
			return sum(A, 0, n - 1);
		if (n == 1)
			return A[0];

		int best = Integer.MAX_VALUE;
		for (int j = 1; j <= n; j++) {
			best = Math.min(best, Math.max(optCost(A, j, k - 1), sum(A, j, n - 1)));
		}
		return best;
	}

	public int sum(int[] A, int from, int to) {

		int total = 0;
		for (int i = from; i <= to; i++) {
			total = A[i] + total;
		}
		return total;
	}

}
