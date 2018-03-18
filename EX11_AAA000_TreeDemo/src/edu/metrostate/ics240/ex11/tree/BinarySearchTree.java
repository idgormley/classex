package edu.metrostate.ics240.ex11.tree;

import java.util.logging.Level;
import java.util.logging.Logger;

import edu.metrostate.ics240.TreeNode;

public class BinarySearchTree {
	static class IntegerTreeNode implements TreeNode<Integer>{

		private TreeNode<Integer> leftChild;
		private TreeNode<Integer> rightChild;
		private Integer value;

		public IntegerTreeNode(Integer i) {
			this.value = i;
		}

		@Override
		public TreeNode<Integer> getLeftChild() {
			return this.leftChild;
		}

		@Override
		public TreeNode<Integer> getRightChild() {
			return this.rightChild;
		}

		@Override
		public Integer getValue() {
			return this.value;
		}

		public void setLeftChild(TreeNode<Integer> newNode) {
			this.leftChild = newNode;
		}

		public void setRightChild(TreeNode<Integer> newNode) {
			this.rightChild = newNode;
		}		
	}
	private IntegerTreeNode root;
	
	public void insert(Integer i) {
		// if (root is null)
		//		set root to new node
		// else if i < root.value
		//		if root.leftChild is null
		//			add new node as left child
		//		else insert i to left child subtree
		// else 
		//		if root.rightChild is null
		//			add new node as right child
		//		else insert i to right child subtree
		IntegerTreeNode newNode = new IntegerTreeNode(i);
		if (root == null) {
			Logger.getLogger(BinarySearchTree.class.getName()).log(Level.INFO, String.format("Setting %d as root", newNode.getValue()));

			root = newNode;
		} else
			insert(root, newNode);
		
	}

	private void insert(IntegerTreeNode subtreeParentNode, IntegerTreeNode  newNode) {
		if (newNode.getValue() < subtreeParentNode.getValue()) {
			if (subtreeParentNode.getLeftChild() == null) {
				Logger.getLogger(BinarySearchTree.class.getName()).log(Level.INFO, String.format("Adding %d as left child of %d", newNode.getValue(), subtreeParentNode.getValue()));
				subtreeParentNode.setLeftChild(newNode);
			} else {
				insert((IntegerTreeNode)subtreeParentNode.getLeftChild(), newNode);
			}
		} else if (subtreeParentNode.getRightChild() == null){
			Logger.getLogger(BinarySearchTree.class.getName()).log(Level.INFO, String.format("Adding %d as right child of %d", newNode.getValue(), subtreeParentNode.getValue()));
			subtreeParentNode.setRightChild(newNode);
		} else {
			insert((IntegerTreeNode)subtreeParentNode.getRightChild(), newNode);
		}
	}
	


	public static void main(String[] args) {

		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(42);
		tree.insert(20);
		tree.insert(62);
		tree.insert(10);
		tree.insert(24);
		tree.insert(50);
		tree.insert(75);
		
		tree.printInOrder();
	}

	public void printInOrder() {
		printInOrder(root, 0);
	}


	private void printInOrder(IntegerTreeNode node, int lvl) {
		if (node != null){
			printInOrder((IntegerTreeNode) node.getLeftChild(), lvl + 1);

			for (int i = 0; i < lvl; i++) {
				System.out.print("\t");
			}
			System.out.printf("%3d\n", node.getValue());
			printInOrder((IntegerTreeNode) node.getRightChild(), lvl + 1);
		}
	}



}
