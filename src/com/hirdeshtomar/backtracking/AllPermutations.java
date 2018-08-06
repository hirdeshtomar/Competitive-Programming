package com.hirdeshtomar.backtracking;

import java.util.Arrays;

public class AllPermutations {

	public static void main(String[] args) {
		
		int[] input = {1,3,5,2};
		
		AllPermutations allPerm = new AllPermutations();
		allPerm.generateAllPermutations(input);

	}
	
	private void generateAllPermutations(int[] input) {
		
		int n = input.length;
		int[] arr = new int[n];
		
		backTrackAllPermutations(arr,-1,n,input);
	}
	
	private void constructCandidates(int[] arr, int k, boolean []c, int[] input) {
		
		for(int i=0; i<k; i++) {
			for(int j=0; j< input.length; j++) {
				if(arr[i] == input[j])
					c[j] = false;
			}
		}
	}
	private boolean isASolution(int k,int n) {
		return k==n-1;
	}
	
	private void processSolution(int[] arr, int n) {
		System.out.print("{");
		for(int i=0; i<n; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.print("}");
		System.out.println("");
	}
	private void backTrackAllPermutations(int[] arr, int k, int n, int[] input) {
		
		boolean[] c = new boolean[n];
		Arrays.fill(c, true);
		
		if(isASolution(k,n)) {
			processSolution(arr,n);
		}else {
			k = k +1;
			constructCandidates(arr, k,c,input);
			for(int i=0; i<c.length; i++) {
				if(c[i]) {
					arr[k] = input[i];
					backTrackAllPermutations(arr,k,n,input);
				}
				
			}
		}
	}

}
