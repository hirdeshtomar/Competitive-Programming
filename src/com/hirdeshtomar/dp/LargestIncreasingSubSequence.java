package com.hirdeshtomar.dp;

import java.util.Arrays;

public class LargestIncreasingSubSequence {
	
	private String findLCS(int[] s1) {
		
		int[] subSeqLen = new int[s1.length];
		int[] preD = new int[s1.length];
		
		
		 findLCSUtil(s1,subSeqLen, preD);
		return null;
	}
	
	private void findLCSUtil(int[] seqChars, int[] subSeqLen, int[]  pred) {
		
		Arrays.fill(pred, -1);
		Arrays.fill(subSeqLen, 0);
		
		subSeqLen[0] = 1;
		
		for(int i=1 ;i < seqChars.length; i++) {
			
			//25473698
			for(int j=0; j<=i-1; j++)
				if(seqChars[j] < seqChars[i] && subSeqLen[j] + 1 > subSeqLen[i]) {
					subSeqLen[i] = subSeqLen[j] + 1;
					pred[i] = j;
				}
			
		}
		
		System.out.println("length: " + subSeqLen[seqChars.length -1]);
		System.out.println(Arrays.toString(subSeqLen));
		System.out.println(Arrays.toString(pred));
		
		int max = 0;
		int maxIdx = 0;
		for(int i=0; i<subSeqLen.length; i++) {
			if(subSeqLen[i] > max) {
				max = subSeqLen[i];
				maxIdx = i;
			}
				
		}
		
		while(maxIdx != -1) {
			
			
			System.out.print(seqChars[maxIdx]);
			maxIdx = pred[maxIdx];
		}
	
		
			
	}
	
	
	public static void main(String args[]) {
		
		int[] s1 = {2,4,3,5,1,7,6,9,8};
		
		LargestIncreasingSubSequence lcs = new LargestIncreasingSubSequence();
		lcs.findLCS(s1);
		
		
		
	}

}
