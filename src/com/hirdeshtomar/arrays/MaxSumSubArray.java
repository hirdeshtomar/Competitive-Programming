package com.hirdeshtomar.arrays;

/*
 * Kadane's Algorithm
 */
public class MaxSumSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {-2,-1,5,4,-3,3,-2,-2};
		
		int curr_sum = 0;
		int max_so_far = Integer.MIN_VALUE;
		
		int start_idx =0;
		int end_idx=0;
		
		for(int i=0; i<arr.length; i++) {
			
				curr_sum = curr_sum + arr[i];
				if(curr_sum < 0) {
					curr_sum =0;
					start_idx = i+1;
					end_idx = start_idx;
				}
			
			
			if(max_so_far < curr_sum) {
				max_so_far = curr_sum;
				end_idx = i;
				
			}
		}

		System.out.println("Start: " + start_idx + " End: " + end_idx);
		System.out.println(max_so_far);
	}

}
