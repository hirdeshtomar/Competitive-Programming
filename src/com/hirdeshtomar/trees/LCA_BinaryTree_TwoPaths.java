package com.hirdeshtomar.trees;

import java.util.ArrayDeque;
import java.util.Deque;


class Node{
	
	int data;
	Node left;
	Node right;
	
	public Node(int data) {
		this.data = data;
		left = null; right = null;
	}
	
}

public class LCA_BinaryTree_TwoPaths {
	
	Node root;
	
	public int findLCAUsingTwoParentPaths(Node root, int n1, int n2) {
		
		int height = height(root);
		
		System.out.println("Height: "+ height);
			
		Deque<Integer> pathStack1 = new ArrayDeque<Integer>();
		Deque<Integer> pathStack2 = new ArrayDeque<Integer>();
		
		int result = root.data;
		
		if(findPath(root, n1, pathStack1) && findPath(root,n2,pathStack2)) {
			
			Deque<Integer> temp = new ArrayDeque<Integer>();
			
			while(!pathStack1.isEmpty()){
				temp.push(pathStack1.pop());
			}
			
			while(!pathStack2.isEmpty()){
				pathStack1.push(pathStack2.pop());
			}
			
			
			
			while(pathStack1.peek() == temp.peek()) {
				
				result = temp.pop();
				pathStack1.pop();
			}
			
		}
		return result;
	
	}
	
	public boolean findPath(Node root, int n , Deque<Integer> pathStack){
		
		if(root == null)
			return false;
		
		pathStack.push(root.data);
		if(root.data == n)
			return true;
		if(findPath(root.left, n, pathStack) || findPath(root.right,n,pathStack))
			return true;
		
		pathStack.pop();
		return false;
	
	}

	public int height(Node root) {
		
		if(root == null)
			return 0;
		
		return 1 + Math.max(height(root.left), height(root.right));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LCA_BinaryTree_TwoPaths tree = new LCA_BinaryTree_TwoPaths();
		
		tree.root = new Node(3);
		tree.root.left = new Node(5);
		tree.root.right = new Node(1);
		tree.root.left.left = new Node(6);
		tree.root.left.right = new Node(2);
		
		tree.root.right.left = new Node(0);
		tree.root.right.right = new Node(8);
		
		tree.root.left.right.left = new Node(7);
		tree.root.left.right.right = new Node(4);
		
		System.out.println("Ancestor: " + tree.findLCAUsingTwoParentPaths(tree.root, 6, 8));
		
		
	}

}
