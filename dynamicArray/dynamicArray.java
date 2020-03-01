public class dynamicArray <T>
{

	private T [] arr;
	private int len = 0;
	private int capacity = 0;

	// Constructor
	public dynamicArray() { this(16); }
	public dynamicArray(int capacity) {
		this.capacity = capacity;
		arr = (T[]) new Object[capacity];
	}

	public int size() { return len; }
	public boolean isEmpty() { return size() == 0; }

	public T get(int index) { 
		if (index >= len || index < 0) throw new IndexOutOfBoundsException();
		return arr[index]; 
	}
	public void set(int index, T element) { 
		if (index >= len || index < 0) throw new IndexOutOfBoundsException();
		arr[index] = element;
	}

	public void clear() {
		for(int i=0; i < len; i++)
			arr[i] = null;
		len = 0; 
	}

	public void add(T element) {
		if (capacity<= len+1) {
			if (capacity == 0)
				capacity = 1;
			else
				capacity = 2*capacity;

			T[] new_array = (T[]) new Object[capacity];
			for(int i = 0; i< len; i++)
				new_array[i] = arr[i];

			arr = new_array;
		}
		arr[len++] = element;
	}

	public T removeElementAtIndex(int index) {
		System.out.println(index);
		// if (index >= len || index < 0) throw new IndexOutOfBoundsException();
		T removedData = arr[index];
		for( int i = 0, j = 0; i < len; i++, j++){
			if (i == index) j--;
			else arr[j] = arr[i];
		}
		len = --len;
		return removedData;
	}

	public int findIndexOfElement(T element) {
		for(int i = 0; i < len; i++)
			if (arr[i]==element) return i;
		return -1;	
	}

	public boolean removeElement(T element) {
		int index = findIndexOfElement(element);
		if (index == -1) return false;
		else {
			removeElementAtIndex(index);
			return true;
		}
	}

	public boolean contains(T element) {
		int index = findIndexOfElement(element);
		if(index==-1) return false;
		else return true;
	}

	public static void main(String[] args) {

		dynamicArray try1 = new dynamicArray(1);

		try1.add(5);
		try1.add(8);
		try1.add(6);

		System.out.println("Initial Size: " + try1.size());

		System.out.println(try1.get(0));
		System.out.println(try1.get(1));
		System.out.println(try1.get(2));

		try1.removeElement(5);

		System.out.println("Final Size: " + try1.size());
	}
}