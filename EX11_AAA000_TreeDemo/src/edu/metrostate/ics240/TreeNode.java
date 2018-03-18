package edu.metrostate.ics240;

public interface TreeNode<T> {
	TreeNode<T> getLeftChild();
	TreeNode<T> getRightChild();
	T getValue();
}
