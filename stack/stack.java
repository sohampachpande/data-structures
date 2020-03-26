// Implementation of stack

class Stack <T> {
	private int size = 0;
	private Node<T> head = null;

	private static class Node<T> {
		private  T data;
		private Node<T> next;

		public Node(T data, Node<T> next){
			this.data = data;
			this.next = next;
		}
	}

	public int getSize() { return size; }

	public boolean isEmpty() { return head==null; }

	public void push(T element) {
		if( isEmpty() ) {
			head = new Node<T>(element, null);
		}
		else {
			head = new Node<T>(element, head);
		}
		size++;
	}

	public void pop() {
		if( isEmpty() ) { throw new RuntimeException("Stack is Empty, nothing to pop!"); }
		head = head.next;
		size--;
	}

	public T peek() {
		if( isEmpty() ) { throw new RuntimeException("Stack is Empty, nothing to pop!"); }
		return head.data;
	}

	public void printStack() {
		Node<T> temp = head;
		for(int i = 0; i < size; i++) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
}

class stackUsingJavaUtil <T> {
	private java.util.LinkedList<T> linkedList = new java.util.LinkedList<T>();

	public int getSize() { return linkedList.size(); }

	public boolean isEmpty() { return getSize() == 0;}

	public void push(T element) {
		linkedList.addFirst(element);
	}

	public void pop() {
	    if (isEmpty()) { throw new RuntimeException("Stack is Empty, nothing to pop!"); }
    	linkedList.removeFirst();
	}

	public T peek() {
	    if (isEmpty()) { throw new RuntimeException("Stack is Empty, nothing to pop!"); }
    	return linkedList.peekFirst();
	}

	public void printStack() {
		System.out.println(linkedList);
	}
}

public class stack {
	public static void main(String[] args){
		// Stack s = new Stack();
		stackUsingJavaUtil s = new stackUsingJavaUtil();

		System.out.println(" Adding Elements ");

		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);



		System.out.println(" Initial Stack ");
		s.printStack();

		s.pop();
		s.pop();
		s.pop();
		
		System.out.println(" After pop ");
		s.printStack();
	}
}