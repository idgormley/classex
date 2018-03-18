package edu.metrostate.ics240.p5.morse;

public interface TreeNode<T> {
	TreeNode<T> getLeftChild();
	TreeNode<T> getRightChild();
	T getValue();
}
