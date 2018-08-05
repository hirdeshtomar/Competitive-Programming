package com.hirdeshtomar.dp;



public class LargestWordInDictionary {
	
	private String findLargestWord(String str, String[] dict) {
		
		int len = 0;
		String longStr = "";
		
		for(String str_dict : dict) {
			if(isSubSequence(str_dict, str) && str_dict.length() > len) {
				len = str_dict.length();
				longStr = str_dict;
			}
		}
		
		return longStr;
		
	}
	
	private boolean isSubSequence(String str_dict, String str) {
		
		int i=0;
		int j=0;
		int n = str_dict.length();
		int m = str.length();
		
		while(i < n && j < m) {
			if(str_dict.charAt(i) == str.charAt(j)) {
				i++;
				j++;
			} else {
				j++;
			}
		}
		
		if(i == n)
			return true;
		return false;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] dict = {"ale", "apple", "monkey", "plea"};
		String str = "abpcplea";
		
		
		LargestWordInDictionary sol = new LargestWordInDictionary();
		
		System.out.println(sol.findLargestWord(str, dict));
		
	}

}
