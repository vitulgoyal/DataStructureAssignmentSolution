package com.gl.question2.drivers;


class Driver {

	public static Node node;
	static Node prevNode;
	static Node headNode;

	// Function to change the binary
	// search tree into a skewed tree in increasing order

	static void changeBSTToSkewed(Node root) {

		// Base Case
		if(root == null) {
			return;
		}

		changeBSTToSkewed(root.left);

		Node rightNode = root.right;

		@SuppressWarnings("unused")
		Node leftNode = root.left;

		// Condition to check if the root Node
		// of the skewed tree is not defined
		if(headNode == null) {
			headNode = root;
			root.left = null;
			prevNode = root;
		} else {
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}

		changeBSTToSkewed(rightNode);
	}

	// Function to traverse the right
	// skewed tree using recursion
	static void traverseRightSkewed(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		traverseRightSkewed(root.right);       
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		node = new Node(50);
		node.left = new Node(30);
		node.right = new Node(60);
		node.left.left = new Node(10);
		node.right.left = new Node(55);

		changeBSTToSkewed(node);
		traverseRightSkewed(headNode);

	}


}



class Node {
	int data;
	Node left; 
	Node right;

	Node(int data) {
		this.data = data;
	}
}