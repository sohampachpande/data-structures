// Implementation of queue using linked list

class Queue<T> {
	private int size = 0;
	private Node<T> head = null;
	private Node<T> tail = null;

	private static class Node<T> {
		private  T data;
		private Node<T> next;

		public Node(T data, Node<T> next){
			this.data = data;
			this.next = next;
		}
	}

	public int getSize() { return size; }

	public boolean isEmpty() { return size==0; }

	// Add new element at the tail of linked list
	public void enqueue(T element) {
		if (isEmpty()) {
			head = tail = new Node<T>(element, null);
		}
		else {
			tail.next = new Node<T>(element, null);
			tail = tail.next;
		}
		size++;
	}

	// Remove element from the head of linkedlist(start)
	public T dequeue() {
		if (isEmpty()) {
			throw new RuntimeException("Queue is Empty, nothing to dequeue! ");
		}
		T temp = head.data;
		head = head.next;
		size--;
		if (isEmpty()) { tail = null; }
		return temp;
	}

	public T peek() {
		if (isEmpty()) {
			throw new RuntimeException("Queue is Empty, nothing to peek! ");
		}
		return head.data;
	}

	public void printQueue() {
		Node<T> temp = head;
		for(int i = 0; i < size; i++) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}


}

public class queue {
	public static void main(String[] args) {
		Queue myQ = new Queue();

		System.out.println(" Adding Elements ");

		myQ.enqueue(99);
		myQ.enqueue(1);
		myQ.enqueue(2);
		myQ.enqueue(3);

		System.out.println(" Peeking... " + myQ.peek());

		myQ.enqueue(4);
		myQ.enqueue(5);



		System.out.println(" Initial Queue ");
		myQ.printQueue();

		myQ.dequeue();
		myQ.dequeue();
		myQ.dequeue();
		
		System.out.println(" After dequeue ");
		myQ.printQueue();
	}
}