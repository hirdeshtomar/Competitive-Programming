package com.hirdeshtomar.dp;

import java.util.Arrays;

/*
 * 
 * ----i----,---y-i-----
 * |
 * i
 * |
 * ----------,
 * |
 * x-i
 * |
 * ----------
 */

public class MinPaperSquareCuts {
    
    private static int findMinSq(int a, int b, int[][] M){
        
      //  System.out.println("A: " + a +"  B: " +b);
        if ( a <= 0 || b<= 0)
            return 0;
        if ( a == b)
            return 1;
        int s = a;
        int l = b;
        if(b < a){
            s = b;
            l = a;
        }
        int result1 = Integer.MAX_VALUE;
        int result2 = Integer.MAX_VALUE;
        /*
        for( int i = 1; i <= s ; i++){
            
            if (M[s-i][l] == -1 )
                 M[s-i][l] = findMinSq(s-i, l,M);
            if (M[i][l-i] == -1)
                 M[i][l-i] = findMinSq(i,l -i,M);
            result1 = Math.min(result1, M[s-i][l] + M[i][l-i] + 1);
        }*/
        
        
        for( int i = 1; i <= l/2 ; i++){
            
            if (M[s][i] == -1 )
                 M[s][i] = findMinSq(s,i,M);
            if (M[s][l-i] == -1)
                 M[s][l-i] = findMinSq(s,l-i,M);
            result1 = Math.min(result1, M[s][i] + M[s][l-i] );
        }
        
        for( int i = 1; i <= s/2 ; i++){
            
            if (M[i][l] == -1 )
                 M[i][l] = findMinSq(i, l,M);
            if (M[s-i][l] == -1)
                 M[s-i][l] = findMinSq(s-i,l,M);
            result1 = Math.min(result1, M[i][l] + M[s-i][l] );
        }
        
        return Math.min(result1, result2);
            
    }
   
    
	public static void main (String[] args) {
		//code
		
		    int a = 14;
		    int b = 16;
		    
		    int[][] M = new int[a+1][b+1];
		    for(int j=0; j<=a; j++)
		        Arrays.fill(M[j],-1);
		    int count = findMinSq(a,b,M);
		    
		    
		    System.out.println(count);
		
		
	}
}
