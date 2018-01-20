package com.hirdeshtomar.graphs;

import java.util.ArrayDeque;
import java.util.Deque;

import com.hirdeshtomar.graphs.GraphAsList.Node;

public class PathBetweenTwoVertices {
	
	public void pathExists(GraphAsList graph, int u, int v){
		boolean[]  visited = new boolean[graph.count];
		Deque<Integer> pathStack = new ArrayDeque<Integer>();
		Deque<Integer> que = new ArrayDeque<Integer>();
		
		pathStack.push(u);
		boolean pathFound = false;
		
		que.push(u);
		
		visited[u] = true;
		
		while(!que.isEmpty() && !pathFound) {
			
			int curr = que.poll();
			
			Node node = graph.adjList[curr].head;
			
			while(node != null) {
				if(!visited[node.dest]) {
					visited[node.dest] = true;
					que.offer(node.dest);
					pathStack.push(node.dest);
					
				}
				
				if(node.dest == v) {
					pathFound = true;
					break;
				}
				
				node = node.next;
			}
		}
		
		if(pathFound) {
			System.out.println("Path Found");
			while(!pathStack.isEmpty()) {
				System.out.print("--" + pathStack.pop());
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GraphAsList graph = new GraphAsList(7);
		boolean[] visited = new boolean[graph.count];

		graph.addEdge(0, 1, 1);
		graph.addEdge(0, 2, 1);
		graph.addEdge(0, 3, 1);

		graph.addEdge(1, 4, 1);
		graph.addEdge(1, 5, 1);

		graph.addEdge(5, 6, 1);
		
		PathBetweenTwoVertices path = new PathBetweenTwoVertices();
				
		path.pathExists(graph, 0, 6);
	}

}
