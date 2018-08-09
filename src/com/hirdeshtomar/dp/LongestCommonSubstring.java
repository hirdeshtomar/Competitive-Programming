package com.hirdeshtomar.dp;

public class LongestCommonSubstring {
	
	
	private int longestCommonSubstring(String s1, String s2){
		int n = s1.length();
		int m = s2.length();

		int[][] mat = new int[n+1][m+1];

		for(int i=0; i<=n;i++){
			mat[i][0] = 0;
		}

		for(int j=0; j<=m;j++){
			mat[0][j] = 0;
		}
		
		int result = 0;
		for(int i=1; i<=n;i++){
			for(int j=1;j<=m;j++) {
				int lastCost =0;
				if(s1.charAt(i-1) == s2.charAt(j-1)){
					lastCost = 1;
				}
				mat[i][j] = Math.max(mat[i-1][j-1] +lastCost, Math.max(mat[i-1][j], mat[i][j-1]));
				result = Math.max(result, mat[i][j]);	
			}
		}
	
	return result;
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestCommonSubstring sol = new LongestCommonSubstring();
		int result = sol.longestCommonSubstring("abc","b");
		System.out.println("Longest common Substring: " + result);
	}

}
