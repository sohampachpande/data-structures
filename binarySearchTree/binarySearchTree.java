// Implementation of priority queue using binary heap

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class BinarySearchTree<T extends Comparable<T>> {

	private int nodeCount = 0;

	private Node root = null;

	private class Node {
		T data;
		Node left, right;

		public Node(T data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	public BinarySearchTree() {
		root = null;
	}

	public int getSize() {
		return nodeCount;
	}

	public boolean isEmpty() {
		return getSize()==0;
	}

	public void add(T element) { root = add(root, element); nodeCount++;}

	public Node add(Node node, T element) {
		if (node==null) {
			node = new Node(element, null, null);
		}
		else {
			int comp = element.compareTo(node.data);
			if (comp<=0) {
				node.left = add(node.left, element);
			}
			else {
				node.right = add(node.right, element);
			}
		}
		return node;
	}

	public boolean find(T element) {
		Node temp = root;

		while (true) {
			if (temp==null) { return false; }
			else {
				int comp = element.compareTo(temp.data);
				if (comp<0) {
					temp = temp.left; 
				}
				else if (comp>0) {
					temp = temp.right;
				}
				else {
					return true;
				}
			}
		}
	} 

	public void remove(T element) {
		remove(root, element);
		nodeCount--;
	}

	public Node remove(Node node, T element) {
		if (node==null) { throw new RuntimeException("Element not found");}

		int comp = element.compareTo(node.data);

		// element is smaller then current node
		// recurse into left subtree
		if (comp<0) { 
			node.left = remove(node.left, element); 
		}
		// similarly recurse into right subtree
		else if (comp>0) { 
			node.right = remove(node.right, element); 
		}
		//when we find the node
		else {
			if (node.left==null) {
				return node.right;
			}
			else if (node.right==null) { 
				return node.left;
			}
			else {
				// find smallest element in right subtree
				Node temp = node.right;
				while(true)
				{
					if (temp.left==null) { break; }
					temp = temp.left;
				}
				node.data = temp.data;
				remove(node.right, temp.data);
			} 
		}
		return node;
	}

	// find the smallest value
	public T findMin() {
		Node temp = root;
		while (temp.left != null) temp = temp.left;
		return temp.data;
	}

	// find the largest value
	public T findMax() {
		Node temp = root;
		while (temp.right != null) temp = temp.right;
		return temp.data;
	}

	// traversal
	public void inorder() {
		if (root==null) {return;}
		System.out.print("Inorder Traversal\n");
		inorder(root);
		System.out.print('\n');
	}
	public void inorder(Node node) {
		if(node.left!=null) { inorder(node.left); }
		System.out.print(node.data);
		System.out.print(' ');
		if(node.right!=null) { inorder(node.right); }
	}

	public void postorder() {
		if (root==null) {return;}
		System.out.print("Postorder Traversal\n");
		postorder(root);
		System.out.print('\n');
	}
	public void postorder(Node node) {
		if(node.left!=null) { postorder(node.left); }
		if(node.right!=null) { postorder(node.right); }
		System.out.print(node.data);
		System.out.print(' ');
	}

	public void preorder() {
		if (root==null) {return;}
		System.out.print("Preorder Traversal\n");
		preorder(root);
		System.out.print('\n');
	}
	public void preorder(Node node) {
		System.out.print(node.data);
		System.out.print(' ');
		if(node.left!=null) { preorder(node.left); }
		if(node.right!=null) { preorder(node.right); }
	}

	public void printRoot() {
		System.out.println(root.data);
	}

}

public class binarySearchTree{
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();

		bst.add(5);
		bst.add(1);
		bst.add(3);
		bst.add(2);
		bst.add(4);
		bst.add(7);
		bst.add(6);

		bst.printRoot();

		bst.inorder();
		bst.preorder();
		bst.postorder();

		bst.remove(5);
		bst.preorder();

		System.out.println(bst.find(5));
		bst.remove(4);
		System.out.println(bst.findMax());

	}
}