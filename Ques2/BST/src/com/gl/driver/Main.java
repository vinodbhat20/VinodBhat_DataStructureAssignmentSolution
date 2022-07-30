package com.gl.driver;

public class Main {

	public static Node node;
	static Node prevNode = null;
	static Node newRoot = null;

	public static void main(String[] args) {

		Main tree = new Main();
		tree.node = new Node(50);
		tree.node.left = new Node(30);
		tree.node.right = new Node(60);
		tree.node.left.left = new Node(10);
		tree.node.right.left = new Node(55);

		printTree(tree.node);
		System.out.println();
		
		convertBSTToSkew(tree.node);

		printTree(newRoot);

	}

	static void printTree(Node root) {
		if (root == null) {
			return;
		}

		System.out.print(root.data + " ");
		printTree(root.left);
		printTree(root.right);
	}

	static void convertBSTToSkew(Node root) {

		if (root == null) {
			return;
		}

		convertBSTToSkew(root.left);

		Node rightNode = root.right;

		if (newRoot != null) {
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		} else {
			newRoot = root;
			root.left = null;
			prevNode = root;
		}

		convertBSTToSkew(rightNode);
	}

}
