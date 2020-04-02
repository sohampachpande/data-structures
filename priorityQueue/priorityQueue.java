// Implementation of priority queue using binary heap

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class BinaryHeap<T extends Comparable<T>> {

	// number of elements in heap heap
	private int heapSize = 0;

	// internal capacity of heap
	private int heapCapacity = 0;

	// specify type of heap - min or max
	private String heapType = "min";

	/* 
	List which contains elements of the heap
	Left and Right child of node with index i are 2xi+1 and 2xi+2 respectively 
	*/
	private ArrayList<T> heap = null;

	// constructor for empty heap
	public BinaryHeap() {
		heap = new ArrayList<>(1);
	}

	public BinaryHeap(String heapType_) {
		heap = new ArrayList<>(1);
		heapType = heapType_;
	}

	// constructor for heap with given size
	public BinaryHeap(String heapType, int heapCapacity) {
		heap = new ArrayList<>(heapCapacity);
		heapType = heapType;
	}

	// Add costructor which accepts list of elements


	public boolean isEmpty() { return heapSize == 0; }

	public int getSize() { return heapSize; }

	public void add(T element) {

		// Set element at last index 
		if(heapSize<heapCapacity) {
			heap.set(heapSize, element);
		}
		// Add element to the end if the list is full
		else {
			heap.add(element);
			heapCapacity++;
		}

		swimUp(heapSize);
		heapSize++;
	}

	boolean heapProperty(int index1, int index2) {
		if (heapType=="min") { 
			return heap.get(index1).compareTo(heap.get(index2)) < 0;
		}
		else {
			return heap.get(index1).compareTo(heap.get(index2)) > 0;
		}		
	} 

	public void swimUp(int index) {
		int parentIndex = (index-1)/2;
		while(index>0 && heapProperty(index, parentIndex)) {
			swap(index, parentIndex);
			index = parentIndex;
			parentIndex = (index-1)/2;
		}
	}

	public void swimDown(int index) {
		while(true) {
			int leftChildIndex = 2*index+1;
			int rightChildIndex = 2*index+2;

			int finalChildIndex = leftChildIndex;
			if ((heapSize > rightChildIndex) && heapProperty(rightChildIndex, leftChildIndex)) {
				finalChildIndex = rightChildIndex;
			}
			

			if (leftChildIndex >= heapSize || heapProperty(index, finalChildIndex)) { break; }
			swap(index, finalChildIndex);
			index = finalChildIndex;
		}
	}

	public void swap(int index1, int index2) {
		T temp = heap.get(index1);
		heap.set(index1, heap.get(index2));
		heap.set(index2, temp);
	}

	public T peekHead() {
		return heap.get(0);
	}

	public T dequeueHead() {
		T temp = heap.get(0);
		heapSize--;
		swap(0,heapSize);
		heap.set(heapSize, null);
		swimDown(0);
		return temp;
	}


	public void printListRepresentation() {
		System.out.println(heap);
	}

}

public class priorityQueue{
	public static void main(String[] args) {
		BinaryHeap myPQ = new BinaryHeap("max");

		myPQ.add(45);
		myPQ.add(2);
		myPQ.add(21);
		myPQ.add(21);
		myPQ.add(1);

		myPQ.printListRepresentation();

		// System.out.println("Peak at Head "+myPQ.peekHead());

		System.out.println("Removed Head "+myPQ.dequeueHead());
		// myPQ.printListRepresentation();
		System.out.println("Removed Head "+myPQ.dequeueHead());
		// myPQ.printListRepresentation();
		System.out.println("Removed Head "+myPQ.dequeueHead());
		// myPQ.printListRepresentation();

		// System.out.println("Peak at Head"+myPQ.peekHead());

		myPQ.printListRepresentation();
	}
}