package com.hirdeshtomar.graphs;

/*
 * Matrix representation of Graph
 * GraphAsMatrix can be used to create graph representing an "count" vertex Graph whose entries are boolean values.
 * Operation like, Adding and Edge, Removing and Edge and Check if two vertex have an edge takes O(1) time.
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
