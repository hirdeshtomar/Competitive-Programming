package com.hirdeshtomar.trees;


public class BST_FromPreOrder_Recusion {

	Node root;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {10,5,1,7,40,50};
		
		BST_FromPreOrder_Recusion tree = new BST_FromPreOrder_Recusion();
		
		tree.root = constructBST(arr, 0, arr.length -1);
		
		printInOrder( tree.root);
		
	}

	private static void printInOrder(Node root) {
		// TODO Auto-generated method stub
		
		if(root == null)
			return;
		printInOrder(root.left);
		System.out.print(root.data +", ");
		printInOrder(root.right);
		
	}

	private static Node constructBST(int[] arr, int i, int j) {
		System.out.println(i +" " + j);
		// TODO Auto-generated method stub
		if(i == j)
			return new Node(arr[i]);
		if(i >j)
			return null;
		int mid_idx =j;
		
		
		Node root = new Node(arr[i]);
		
		for(int k=i; k<=j; k++) {
			if(arr[k] >arr[i]) {
				
				mid_idx = k;
				break;
			}
				
		}
		
		System.out.println("mid_IDx" + mid_idx);
		
		root.left = constructBST(arr,i+1,mid_idx-1);
		root.right = constructBST(arr,mid_idx,j);
		
		return root;
	}

}
