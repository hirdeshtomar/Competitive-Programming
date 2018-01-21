package com.hirdeshtomar.arrays;

public class StockBuySell {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {100,180,260,310,40,535,695};
		
		System.out.println(findMaxProfit(arr));

	}

	private static int findMaxProfit(int[] arr) {
		// TODO Auto-generated method stub
		if(arr.length == 0 || arr.length == 1)
			return 0;	
		
		int result = 0;
		int local_min = arr[0];
		int local_max = Integer.MIN_VALUE;
		
		for(int i=1; i<arr.length; i++) {
			
			if(i== arr.length -1) {
				if(arr[i] >= arr[i-1])
					return result + arr[i] - local_min;
				else
					return result + local_max - local_min;
			}
			
			if(arr[i-1] <= arr[i])
				local_max = arr[i];
			else {
				result = result + local_max - local_min;
				local_min = arr[i];
			}
				
		}
		
		return result;
	}

}
