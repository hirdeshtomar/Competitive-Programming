package com.hirdeshtomar.graphs;

import java.util.ArrayDeque;
import java.util.Queue;

import com.hirdeshtomar.graphs.GraphAsList.Node;

public class BFS_Queue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GraphAsList graph = new GraphAsList(6);
		boolean[] visited = new boolean[graph.count];

		graph.addEdge(0, 1, 1);
		graph.addEdge(0, 2, 1);
		graph.addEdge(0, 3, 1);

		graph.addEdge(1, 4, 1);
		graph.addEdge(1, 5, 1);

		BFS_Queue bfs_que_algo = new BFS_Queue();
		bfs_que_algo.bfs(graph, visited, 0);

	}

	public void bfs(GraphAsList graph, boolean[] visited, int start) {

		Queue<Integer> queue = new ArrayDeque<Integer>();

		visited[start] = true;
		System.out.println("Visited: " + start);

		queue.offer(start);

		while (!queue.isEmpty()) {

			int current = queue.poll();

			Node node = graph.adjList[current].head;

			while (node != null) {
				if (!visited[node.dest]) {
					System.out.println("Visitng Node: " + node.dest);
					visited[node.dest] = true;
					queue.offer(node.dest);
				}

				node = node.next;
			}

		}
	}

}
