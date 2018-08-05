package com.hirdeshtomar.dp;

public class EditDistanceProblem {
	
	private int findEditDistance(String s, String t) {
		
		int result = 0;
		int n = s.length();
		int m = t.length();
		
		int[][] M = new int[n+1][m+1];
		
		for(int i=0; i<=n ; i++) {
			M[i][0] = i;
		}
		
		for(int j=0; j<=m ; j++) {
			M[0][j] = j;
		}
		
		result = findEditDistanceUtil(s,t,M,n,m);
		return result;
	}
	
	private void printM(int[][] M, int n, int m) {
		for(int i=0; i<=n; i++) {
			for( int j=0 ; j<= m ; j++) {
				if(M[i][j] <10)
					System.out.print(" " +M[i][j] +", ");
				else
					System.out.print(M[i][j] +", ");
			}
			System.out.println("");
		}
	}
	private int findEditDistanceUtil(String s, String t, int[][] M, int n, int m) {
		
		
		int insCost = 1;
		int delCost = 1;
		char[][] parent = new char[n+1][m+1];
		for(int i=1; i<=n ;i++) {
			int matchRepCost = 1;
			for(int j=1; j<=m; j++) {
				
				if(s.charAt(i-1) == t.charAt(j-1)) {
				//	System.out.print("Match   : " + s.charAt(i-1) + "," +t.charAt(j-1));
					matchRepCost = 0;
				} else {
				//	System.out.print("No Match: " + s.charAt(i-1) + "," +t.charAt(j-1));
					matchRepCost = 1;
				}
				
				
				M[i][j] = Math.min(M[i-1][j-1] + matchRepCost, Math.min(M[i][j-1] + insCost, M[i-1][j] + delCost ) );
			/*	System.out.print(" Mat Cost: " + (M[i-1][j-1] + matchRepCost) +", ");
				System.out.print("Ins Cost: " + (M[i-1][j] + insCost) +", ");
				System.out.print("Del Cost: " + (M[i][j-1] + delCost)+", ");
				System.out.print("M[" +i+ "," +j +"] : " + M[i][j]);
				System.out.println("");*/
				
				
				
			}
		}
		
		printM(M,n,m);
		System.out.println("");
		printPath(M,n,m,s,t);
		System.out.println("");
		return M[n][m];
	}
	
	public void printPath(int[][] M,int n, int m , String s, String t) {
		
		if(n<=0 || m<=0)
			return;
		char opt = 'M';
		int match = M[n-1][m-1] ;
		int insert = M[n-1][m] ;
		int delete = M[n][m-1] ;
		
		if(match > insert) {
			if(insert > delete) {
				opt = 'D';
			} else {
				opt = 'I';
			}
		} else {
			if(match <= delete) {
				opt = 'M';
			} else {
				opt = 'D';
			}
				
		}
		
		if(opt == 'M') {
			if(M[n][m] == M[n-1][m-1])
				System.out.print("M");
			else
				System.out.print("S");
			printPath(M,n-1,m-1,s,t);
		} else if (opt == 'D') {
			System.out.print("D");
			printPath(M,n,m-1,s,t);
		} else {
			System.out.print("I");
			printPath(M,n-1,m,s,t);
		}
		
	}
	
	public static void main(String args[]) {
		
		String s = "thou shalt not";
		String t = "you should not";
		
		EditDistanceProblem solution = new EditDistanceProblem();
		int dis = solution.findEditDistance(s,t);
		System.out.println("Edit Distance: " + dis);
	}

}
