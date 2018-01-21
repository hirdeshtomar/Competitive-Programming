package com.hirdeshtomar.arrays;

import java.util.HashSet;
import java.util.Set;

public class SumAsXOfTwoElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {41, 35, -62,-5,97,108};
		int x = 36;
		Set<Integer> hm = new HashSet<Integer>();
		
		for(int i=0; i<arr.length; i++) {
			
			if(hm.contains(x - arr[i]))
				System.out.println("Found: " + arr[i]+ ", " + (x-arr[i]));
			else
				hm.add(arr[i]);
			
		}
	}

}
