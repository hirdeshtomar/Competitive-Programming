package com.hirdeshtomar.arrays;

public class MaxProductSubArray {
	
	private int maxSubArrayProduct(int[] nums) {
		
		int maxProd = 1, currMax = 1, currMin = 1, n = nums.length;
		
		for(int i=0; i<n;i++) {
			System.out.println("Befor=> MaxProd: " + maxProd +  ", currMin: "+ currMin+" currMax: " + currMax);
			if(nums[i] > 0) {
				currMax = currMax*nums[i];
				currMin = Math.min(currMin, currMin*nums[i]);
			} else if(nums[i] == 0) {
				currMax = 1;
				currMin = 1;
			} else {
				int temp = currMax*nums[i];
				currMax = currMin*nums[i];
				currMin = temp;
			}
			
			if(currMax > maxProd)
				maxProd = currMax;
			
			System.out.println("After=> MaxProd: " + maxProd +  ", currMin: "+ currMin+" currMax: " + currMax);
		}
		
		return maxProd;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,2,4,0,-1};
		MaxProductSubArray sol = new MaxProductSubArray();
		System.out.println(sol.maxSubArrayProduct(nums));
	}

}
