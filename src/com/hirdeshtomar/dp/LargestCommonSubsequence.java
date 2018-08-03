package com.hirdeshtomar.dp;

public class LargestCommonSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str1 = "ABCDGH";
		String str2 = "AEDFHR";
		
		System.out.println(findLCS(str1,str2));

	}

	private static String findLCS(String str1, String str2) {
		// TODO Auto-generated method stub
		if(str1 == "" || str2 =="" || str1.isEmpty() || str2.isEmpty())
			return "";
		
		if(str1.charAt(0) == str2.charAt(0))
			return str1.charAt(0) + findLCS(str1.substring(1), str2.substring(1));
		else
			return MaxLengthString(findLCS(str1, str2.substring(1)) , findLCS(str1.substring(1),str2));
	}
	
	private static String MaxLengthString(String str1, String str2) {
		if(str1.length()>=str2.length())
			return str1;
		else
			return str2;
	}
	
}
