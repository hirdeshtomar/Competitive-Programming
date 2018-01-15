package com.hirdeshtomar.graphs;

public class GraphAsList {
	
	class Node{
		int src;
		int dest;
		int cost;
		
		Node next;
		
		public Node(int src, int dest, int cost) {
			this.src = src;
			this.dest = dest;
			this.cost = cost;
			next = null;
		}
	}
	
	class AdjList{
		Node head;
		
		public AdjList() {
			head = null;
		}
	}
	
	int count;
	AdjList[] adjList;
	
	public GraphAsList(int count) {
		
		this.count = count;
		
		adjList = new AdjList[count];
		for(int i=0; i<count; i++) {
			adjList[i] = new AdjList();
			adjList[i].head = null;
		}
	}
	
	public void addEdge(int src, int dest, int cost) {
		
		Node newNode = new Node(src, dest, cost);
		if(adjList[src].head == null) {
			System.out.println("adding " + dest + " as First Node for " + src + "...");
			adjList[src].head = newNode;
		}
		else {
			System.out.println("...adding " + dest + " as next Node for " + src);
			newNode.next = adjList[src].head;
			adjList[src].head = newNode;
		}
			
		
	}
	
	public void print() {
		System.out.println("printing..");
		
		for(int i=0; i<count; i++) {
			Node node = adjList[i].head;
			if(node == null)
				System.out.println("Node "+ i + " Not Connected");
			else {
				System.out.print("[" + node.src +"]");
				while(node != null) {
					System.out.print("---" + node.cost + "---(" + node.dest+ ")");
					node = node.next;
				}
				System.out.println("");
			}
		}
	}
	
	public static void main(String args[]) {
		
		GraphAsList gph = new GraphAsList(5);
		
		gph.addEdge(0, 1, 10);
		gph.addEdge(0, 4, 50);
		gph.addEdge(1,0,10);
		gph.addEdge(1, 4, 20);
		gph.addEdge(2, 3, 5);
		gph.addEdge(3, 2, 5);
		gph.addEdge(4, 0, 50);
		gph.addEdge(4, 1, 20);
		
		gph.addEdge(3, 4, 10);
		gph.addEdge(4, 3, 10);
		gph.addEdge(1 ,2, 10);
		gph.addEdge(2, 1, 10);
		
		gph.print();
		
	}

}
