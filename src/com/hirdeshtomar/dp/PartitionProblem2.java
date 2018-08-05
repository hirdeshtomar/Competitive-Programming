package com.hirdeshtomar.dp;

public class PartitionProblem2 {
	
	
	private void weightedPartition(int[] arr, int k) {
		
		
	}
	
	private int weightedPartitionUtil(int[] arr, int i){
		
		if(i < 0)
			return 0;
		
		int sum = 0;
		for(int j=i+1; j<arr.length; j++) {
			sum = sum + arr[j];
			Math.min(weightedPartitionUtil(arr,j), sum);
		}
	
		return sum;
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = { 100, 100, 200, 300, 300, 400, 500, 600 };
		int k = 3;
		
		PartitionProblem2 wtPartition = new PartitionProblem2();
		wtPartition.weightedPartition(arr,k);
		

	}

}
