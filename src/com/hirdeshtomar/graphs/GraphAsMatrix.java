package com.hirdeshtomar.graphs;

/*
 * Adjacency List representation of Graph
 * GraphAsList can be used to create graph as an array of adjacent list, 
 * where all nodes in the ith list represents the nodes that are directly connected to ith node in the graph
 * 
 * Created by Hirdesh Tomar - 16 Jan 2018
 */

public class GraphAsMatrix {
	
	int count;
	boolean[][] AdjMatrix;
	
	public GraphAsMatrix(int count) {
		this.count = count;
		AdjMatrix = new boolean[count][count];
	}
	
	public void addEdge(int src, int dest) {
		
		AdjMatrix[src][dest] = true;
	}
	
	public void removeEdge(int src, int dest) {
		AdjMatrix[src][dest] = false;
	}
	
	boolean hasEdge(int src, int dest) {
		return AdjMatrix[src][dest];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
