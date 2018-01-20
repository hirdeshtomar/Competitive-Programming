package com.hirdeshtomar.graphs;

import java.util.ArrayDeque;
import java.util.Deque;

public class TopologicalSort_DFS {

	static Deque<Integer> stack = new ArrayDeque<Integer>();
	static boolean visited[];
	
	public static void topo_sort_dfs(int current_index, int[][] graph, Deque<Integer> stack, boolean[] visited) {
		
		visited[current_index] = true;	
		for(int i=0; i< graph.length; i++) {
			
			if(graph[current_index][i] != 0 && !visited[i])
				topo_sort_dfs(i, graph, stack, visited);
		}
		
		stack.push(current_index);		
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
           
           visited = new boolean[graph.length];
           for(int i=0; i<graph.length;i++) {
        	   if(!visited[i]) {
        		   visited[i] = true;
        		   topo_sort_dfs(i, graph, stack, visited);
        	   }
           
           }
           
           while(!stack.isEmpty()) {
        	   System.out.print(stack.pop() + " ");
           }
           
           
		

	}

}
