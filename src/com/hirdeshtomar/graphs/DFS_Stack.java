package com.hirdeshtomar.graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import com.hirdeshtomar.graphs.GraphAsList.Node;

public class DFS_Stack {
	
	
	public void DFSTraversal(GraphAsList gph, int startNode) {
		
		int count = gph.count;
		boolean[] visited = new boolean[count];
		
		Deque<Integer> stack = new ArrayDeque<Integer>();
		
		Arrays.fill(visited, false);
		
		visited[startNode] = true;
		
		System.out.println("Start Node Visited: " + startNode);
		
		stack.push(startNode);
		
		int current;
		
		while(!stack.isEmpty()) {
			
			current = stack.pop();
			
			Node currNode = gph.adjList[current].head;
			while(currNode != null) {
				if(!visited[currNode.dest]){
					visited[currNode.dest] = true;
					System.out.println("Node Visited: " + currNode.dest);
					stack.push(currNode.dest);
				}
				
				currNode = currNode.next;
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GraphAsList gph = new GraphAsList(5);
		
		gph.addEdge(0, 1, 10);
		gph.addEdge(0, 4, 50);
		gph.addEdge(1, 0, 10);
		gph.addEdge(1, 4, 20);
		gph.addEdge(2, 3, 5);
		gph.addEdge(3, 2, 5);
		gph.addEdge(4, 0, 50);
		gph.addEdge(4, 1, 20);

		gph.addEdge(3, 4, 10);
		gph.addEdge(4, 3, 10);
		gph.addEdge(1, 2, 10);
		gph.addEdge(2, 1, 10);
		
		DFS_Stack dfsTraversal = new DFS_Stack();
		dfsTraversal.DFSTraversal(gph, 0);
	}

}
