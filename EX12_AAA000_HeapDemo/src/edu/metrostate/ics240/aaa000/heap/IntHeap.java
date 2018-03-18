package edu.metrostate.ics240.aaa000.heap;

class EmptyHeapException extends RuntimeException

{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4829211132789308424L;

}
 public class IntHeap {

	private final static int DEFAULT_HEAP_CAPACITY = 16;
	private final static int NO_NODE = -1;
	private final static int ROOT_NODE = 0;
	
	private int [] heap;
	private int heapSize;
	

	public IntHeap() {
		heap = new int [DEFAULT_HEAP_CAPACITY];
	}
	
	public void add(int newVal) {
		// add value to end of heap
		// "reheapify" from the new node
		ensureCapacity();
		heap[heapSize] = newVal;
		reHeapify(heapSize);
		heapSize++;
	}
	
	private void ensureCapacity() {
		if (heapSize == heap.length){
			int [] newHeap = new int[heap.length * 2 + 1];
			System.arraycopy(heap, 0, newHeap, 0, heap.length);
			heap = newHeap;
		}
	}

	private int getGreaterChild(int nodeIndex) {
		int greaterNode = NO_NODE;
		int leftChild = leftChild(nodeIndex);
		int rightChild = rightChild(nodeIndex);
		if (hasLeftChild(nodeIndex) && heap[leftChild] > heap[nodeIndex]) {
			if (hasRightChild(nodeIndex) && heap[rightChild] > heap[nodeIndex]) {
				greaterNode = Integer.compare(heap[leftChild], heap[rightChild]) >= 0 ? leftChild : rightChild;
			} else
				greaterNode = leftChild;
		} else if (hasRightChild(nodeIndex) && heap[rightChild] > heap[nodeIndex]) {
			greaterNode = rightChild;
		}
		return greaterNode;
	}

	private boolean hasLeftChild(int nodeIndex) {
		return leftChild(nodeIndex) < heapSize;
	}

	private boolean hasRightChild(int nodeIndex) {
		return rightChild(nodeIndex) < heapSize;
	}

	public boolean isEmpty(){
		return heapSize == 0;
	}

	private int leftChild(int nodeIndex) {
		return 2 * nodeIndex + 1;
	}

	private int parentOf(int nodeIndex) {
		return (nodeIndex -1) / 2;
	}

	public int peek() {
		if (isEmpty()) {
			throw new EmptyHeapException();
		}
		return heap[ROOT_NODE];
	}

	private void reHeapify(int nodeIndex) {
		if (nodeIndex != 0 && heap[parentOf(nodeIndex)] < heap[nodeIndex]){
			swap(parentOf(nodeIndex), nodeIndex);
			reHeapify(parentOf(nodeIndex));
		} else {
			
			int greaterChild = getGreaterChild(nodeIndex);
			if (greaterChild != NO_NODE){
				swap(nodeIndex, greaterChild);
				reHeapify(greaterChild);
			}
		}
	}

	public int remove() {
		// remove and save value of root
		// move end value to root and reduce size of heap
		// reheapify from the root
		if (isEmpty()) {
			throw new EmptyHeapException();
		}
		int returnValue = heap[ROOT_NODE];
		heap[ROOT_NODE] = heap[--heapSize];
		reHeapify(ROOT_NODE);
		return returnValue;
	}
	
	private int rightChild(int nodeIndex) {
		return 2 * nodeIndex + 2;
	}
	
	public int size(){
		return heapSize;
	}
	
	private void swap(int index1, int index2) {
		int tmpValue = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = tmpValue;
	}
	public void printHeap(){
		printHeap(ROOT_NODE, 0);
	}

	private void printHeap(int node, int level) {
		if (node < heapSize) {
			printHeap(leftChild(node), level + 1);
			for(int i = 0; i < level; i++){
				System.out.print("\t");
			}
			System.out.println(heap[node]);
			printHeap(rightChild(node), level + 1);
		}
	}
 }
