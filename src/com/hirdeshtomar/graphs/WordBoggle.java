package com.hirdeshtomar.graphs;

import java.util.Arrays;

public class WordBoggle {
	
	private void findWords(String[] dict, char[][] mat) {
		int n = mat.length;
		int m = mat[0].length;
		for(String str : dict) {
			boolean[][] visited = new boolean[n][m];
			if(wordExists(mat,str,visited))
				System.out.println(str);
		}
	}

	private boolean wordExists(char[][] mat, String str, boolean[][] visited) {
		
		char[] allChars = str.toCharArray();
		for(int i=0; i<allChars.length; i++) {
			int[] firstCharIndices = new int[2];
			Arrays.fill(firstCharIndices, -1);
			firstCharIndices = findFirstChar(mat, allChars[i],visited);
			
			if(firstCharIndices == null)
				return false;
			return traceWord(mat,firstCharIndices,visited, allChars,1);
			
			
		}
		
		return false;
	}

	private int[] findFirstChar(char[][] mat, char c, boolean[][] visited) {
		
		for(int i=0; i<mat.length;i++) {
			for(int j=0; j<mat[0].length; j++) {
				if(mat[i][j] == c) {
					int[] firstCharIndices =  {i,j};
					return firstCharIndices;
				}
					
			}
		}
		
		return null;
	}

	private boolean traceWord(char[][] mat, int[] charIndices, boolean[][] visited, char[] allChars, int k) {
		// TODO Auto-generated method stub
		
		if(k == allChars.length )
			return true;
		int row = charIndices[0];
		int col = charIndices[1];
		
		int adjRow[] = {-1,-1,-1,0,0,1,1,1};
		int adjCol[] = {-1,0,1,-1,1,-1,0,1};
		
		for(int i=0; i<8;i++) {
			
			if(isSafe(row+adjRow[i], col + adjCol[i], mat)) {
				if(!visited[row+adjRow[i]][col + adjCol[i]] && mat[row+adjRow[i]][col + adjCol[i]] == allChars[k] ) {
					visited[row+adjRow[i]][col + adjCol[i]] = true;
					charIndices[0] = row + adjRow[i];
					charIndices[1] = col + adjCol[i];
					return traceWord(mat,charIndices,visited,allChars,k+1);
				}
			}
		}
		return false;
		
	}

	private boolean isSafe(int i, int j, char[][] mat) {
		// TODO Auto-generated method stub
		if(i<0 || j<0 || i >= mat.length || j>=mat[0].length)
			return false;
		else
			return true;
	}

	public static void main(String[] args) {
		
		String[] dict = {"GEEKS", "FOR", "QUIZ", "GO", "ARTI"};
		char[][] mat = {{'G','I','Z'},
                			{'U','E','I'},
                			{'Q','R','T'},
                			{'A','H','R'}};
		WordBoggle wordBoggle = new WordBoggle();
		wordBoggle.findWords(dict,mat);

	}

}
