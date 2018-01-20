package com.hirdeshtomar.graphs;

import java.util.Arrays;

public class TopologicalSort_BFS {

	public void topological_sort(int n, int[][] graph) {
		
		int[] T = new int[n];
		int index = 0;
		
		int[] in_degree = new int[n];
		
		boolean visited[] = new boolean[n];
	
		for(int i =0; i< n ; i++) {
			
			for(int j=0; j< n; j++) {
				
				if(graph[i][j] != 0) {				
					in_degree[j]++;
				}
			}
		}
		
		System.out.println(Arrays.toString(in_degree));
		
		while(index != n ) {	
			//System.out.println("Looping" + index);
			System.out.println();
			System.out.println(Arrays.toString(visited));
			System.out.println(Arrays.toString(in_degree));
			for(int i=0 ;i<n; i++) {
				if(in_degree[i] == 0 && !visited[i]) {
					T[index] = i;
					index++;
					visited[i] = true;
					for(int j=0; j<n; j++) {
						if(graph[i][j] !=0)
							in_degree[j]--;
					}
					break;
				}
				
			}
			
		}
		
		System.out.println(Arrays.toString(T));
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] graph = new int[][] {
			{0, 4, 0, 0, 0, 0, 0, 8, 0},
            {0, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 0, 0, 0, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 0, 0, 10, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 6},
            {0, 0, 0, 0, 0, 0, 0, 0, 7},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}
           };
           
           TopologicalSort_BFS obj = new TopologicalSort_BFS();
           obj.topological_sort(9, graph);

	}

}
