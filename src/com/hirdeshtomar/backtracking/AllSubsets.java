package com.hirdeshtomar.backtracking;

public class AllSubsets {

	public static void main(String[] args) {
		int[] input = {1, 2, 4};
		AllSubsets allSub = new AllSubsets();
		allSub.generate_subsets(input);
	}
	
	private void generate_subsets(int[] input) {
		int n = input.length;
		int[] arr = new int[n];
		backtrack(arr,-1,n, input);	
	}
	
	private void backtrack(int[] arr, int k, int n, int[] input) {
		int MAX_CANDIDATES = 2;
		int[] c = new int[MAX_CANDIDATES];
		if(isASolution(arr,k,n)) {
			processSolution(arr,k,n,input);
		} else {
			k=k+1;
			constructCandidates(arr, k, n, c);
			for(int i=0; i<c.length; i++) {
				arr[k] = c[i];
				backtrack(arr,k,n,input);
			}
		}
	}

	private void constructCandidates(int[] arr, int k, int n, int[] c) {
		c[0] = 0;
		c[1] = 1;
	}

	private boolean isASolution(int[] arr, int k, int n) {
		return k==n-1;
	}

	private void processSolution(int[] arr, int k, int n, int[] input) {
		System.out.print("{");
		for(int i=0;i<arr.length;i++) {
			if(arr[i] == 1) {
				System.out.print(input[i]+",");
			}
		}
		System.out.print("}");
		System.out.println("");	
	}
}
