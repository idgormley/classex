package edu.metrostate.ics240.p5.IDG091.morse;

import java.util.Stack;

import edu.metrostate.ics240.p5.morse.TreeNode;

public class DecodingTree {
	static class CharacterTreeNode implements TreeNode<Character> {
		private TreeNode<Character> leftChild;
		private TreeNode<Character> rightChild;
		private Character value;

		public CharacterTreeNode(Character i) {
			this.value = i;
		}

		@Override
		public TreeNode<Character> getLeftChild() {
			return this.leftChild;
		}

		@Override
		public TreeNode<Character> getRightChild() {
			return this.rightChild;
		}

		@Override
		public Character getValue() {
			return this.value;
		}

		public void setLeftChild(TreeNode<Character> newNode) {
			this.leftChild = newNode;
		}

		public void setRightChild(TreeNode<Character> newNode) {
			this.rightChild = newNode;
		}

	}

	private TreeNode<Character> root;

	public DecodingTree() {
		root = new CharacterTreeNode(null);
	}

	public TreeNode<Character> getRoot() {
		return this.root;
	}

	public void preorder(TreeNode<Character> root) {
		StringBuilder out = new StringBuilder();
		if (root == null)
			return;
		Stack<TreeNode<Character>> stack = new Stack<TreeNode<Character>>();
		stack.push(root);
		while (!stack.empty()) {
			TreeNode<Character> n = stack.pop();
			out.append(n.getValue());
			if (n.getLeftChild() != null) {
				stack.push(n.getLeftChild());
			}
			if (n.getRightChild() != null) {
				stack.push(n.getRightChild());
			}
		}
	}

	public void insert(Character character, String code) {

		CharacterTreeNode newNode = new CharacterTreeNode(character);
		int i = 1;
		if (root.getValue() == null) {
			root = new CharacterTreeNode('/');
		}
		if (root.getLeftChild() == null) {
			if ((code.charAt(i - 1) == '-') && (code.length() == i))
				((CharacterTreeNode) root).setLeftChild(newNode);
		} else if (root.getRightChild() == null) {
			if ((code.charAt(i - 1) == '*') && (code.length() == i))
				((CharacterTreeNode) root).setRightChild(newNode);
		} else if (code.length() > i) {
			if ((code.charAt(i - 1) == '-') && (root.getLeftChild() != null)) {
				insert(root.getLeftChild(), newNode, code, i);
			} else if ((code.charAt(i - 1) == '*') && (root.getRightChild() != null)) {
				insert(root.getRightChild(), newNode, code, i);
			}
		}
	}

	public void insert(TreeNode<Character> parentNode, CharacterTreeNode newNode, String code, int i) {
		i++;
		if (code.charAt(i - 1) == '-') {
			if (code.length() == i) {
				if (parentNode.getLeftChild() == null)
					((CharacterTreeNode) parentNode).setLeftChild(newNode);
			} else
				insert(parentNode.getLeftChild(), newNode, code, i);

		} else if (code.charAt(i - 1) == '*') {
			if (code.length() == i) {
				if (parentNode.getRightChild() == null)
					((CharacterTreeNode) parentNode).setRightChild(newNode);
			} else
				insert(parentNode.getRightChild(), newNode, code, i);
		}
	}
}
