// Implementation of singlyLinkedList

class singlyLinkedList <T> {

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

	public boolean isEmpty() { return getSize() == 0;}

	public void clearList(){
		head = tail = null;
	}

	public void addToEnd(T element){
		if (head == null) {
			head = tail = new Node<T>(element, null);
		}
		else{
			tail.next = new Node<T>(element, null);
			tail = tail.next;
		}
		size++;	
	}

	public void addToStart(T element){
		if (head == null) {
			head = tail = new Node<T>(element, null);
		}
		else{
			head = new Node<T>(element, head);
		}
		size++;
	}


	public void addToIndex(int index, T element){
		// Throw exception if invalid index
		if (index < 0 || index > size) { throw new RuntimeException("Illegal Index"); }

		// Add to Start
		if (index==0) { addToStart(element); }

		// Add to End
		else if (index==size) { addToEnd(element); }

		// Add at Index
		else {
			Node<T> temp = head;
			for(int i = 0; i < index - 1 ; i++){
				temp = temp.next;
			}
			temp.next = new Node<T>(element, temp.next);
			size++;
		}
	}

	public void removeLast(){
		if ( size == 0 ) { throw new RuntimeException("Empty list"); }

		// Find pointer second last element
		Node<T> temp = head;
		for(int i = 0; i < size - 1; i++){
			temp = temp.next;
		}
		tail = temp;
		tail.next = null;
		size--;

		// Change head and tail if list empty
		if ( size == 0 ) {
			head = tail = null;
		}
	}

	public void removeStart(){
		if ( size == 0 ) { throw new RuntimeException("Empty list"); }

		head = head.next;
		size--;

		if ( size == 0 ) {
			tail = null;
		}
	}

	public void removeAtIndex(int index){
		// Throw exception if invalid index
		if (index < 0 || index > size) { throw new RuntimeException("Illegal Index"); }

		// Remove from Start
		if (index==0) { removeStart(); }

		// Remove from End
		else if (index==size) { removeLast(); }

		// Remove from Index
		else {
			Node<T> temp = head;
			for(int i = 0; i < index - 1 ; i++){
				temp = temp.next;
			}
			temp.next = temp.next.next;
			size--;
		}


	}

	public int searchElementIndex(T element){
		Node<T> temp = head;
		for(int i = 0; i < size; i++) {
			if (temp.data == element) { return i; }
			temp = temp.next;
		}
		return -1;
	}
	
	public void removeElement(T element){
		int index = searchElementIndex(element);
		if (index==-1) { throw new RuntimeException("Item not found"); }
		else {
			removeAtIndex(index);
		}
	}

	public void printLinkedList(){
		Node<T> temp = head;
		for(int i = 0; i < size; i++) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

}



public class linkedList {
	public static void main(String[] args) {

		singlyLinkedList ll1 = new singlyLinkedList();

		System.out.println("Adding elements \n");

		ll1.addToStart(1);
		ll1.addToEnd(2);
		ll1.addToEnd(3);
		ll1.addToStart(0);
		ll1.addToEnd(4);
		ll1.addToEnd(5);
		ll1.addToEnd(6);

		ll1.addToIndex(7, 7);

		System.out.println("Intial List:");
		ll1.printLinkedList();

		System.out.println("\nDeleting elements \n");

		ll1.removeAtIndex(3);
		ll1.removeLast();
		ll1.removeStart();
		ll1.removeElement(4);
		System.out.println("Final List:");
		ll1.printLinkedList();



	}
}