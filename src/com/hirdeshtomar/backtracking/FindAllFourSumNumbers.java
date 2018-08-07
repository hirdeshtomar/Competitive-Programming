package com.hirdeshtomar.backtracking;


public class FindAllFourSumNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {10, 2, 3, 4, 5, 9, 7, 8};
		int k = 23;
		FindAllFourSumNumbers sol = new FindAllFourSumNumbers();
		sol.generateFourSums(arr,k);
	}

	private void generateFourSums(int[] arr, int k) {

		int[] result = new int[arr.length];
		int x = -1;
		backTrackFourSums(arr,k,result,x);
	}

	private void backTrackFourSums(int[] arr, int k, int[] result, int x) {

		int[] c = {0,1};	
		if(isASolution(result, k,arr,x) ){
			processSolution(result, arr,x);
		} else {
			x = x+1;
			for(int i=0; i< c.length;i++) {
					result[x] = c[i];
					backTrackFourSums(arr,k,result,x);
			}
		}	
	}

	private void processSolution(int[] result, int[] arr,int x) {
		if(x == arr.length-1)
			return;
		for(int i=0; i<result.length;i++) {
			if(result[i] == 1)
				System.out.print(arr[i] + ", ");
		}
		System.out.println("");
	}

	private boolean isASolution(int[] result, int k, int[] arr, int x) {
		
		if(x == arr.length-1)
			return true;
		
			int count = 0;
			int sum = 0;
			for(int i=0; i<result.length; i++) {
				if(result[i] ==1) {
					sum = sum + arr[i];
					count++;
				}	
			}
			return count == 4 && sum==k;

	}
}
