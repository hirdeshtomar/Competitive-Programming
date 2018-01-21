package com.hirdeshtomar.trees;


/* Assumes both Nodes are present in Tree*/

public class LCA_BinaryTree_SingleTraversal {
	
	
	Node root;
	
	public Node findLCA(Node root, int n1, int n2) {
		
		if(root == null || root.data == n1 || root.data == n2)
			return root;
		Node left = findLCA(root.left, n1, n2);
		Node right = findLCA(root.right, n1,n2);
		
		if(left != null && right != null)
			return root;
		return left!=null? left: right;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
LCA_BinaryTree_SingleTraversal tree = new LCA_BinaryTree_SingleTraversal();
		
		tree.root = new Node(3);
		tree.root.left = new Node(5);
		tree.root.right = new Node(1);
		tree.root.left.left = new Node(6);
		tree.root.left.right = new Node(2);
		
		tree.root.right.left = new Node(0);
		tree.root.right.right = new Node(8);
		
		tree.root.left.right.left = new Node(7);
		tree.root.left.right.right = new Node(4);
		
		System.out.println("Ancestor: " + tree.findLCA(tree.root, 8, 0).data);

	}

}
