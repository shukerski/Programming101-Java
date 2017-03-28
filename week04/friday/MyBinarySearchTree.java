package com.week04.friday;

public class MyBinarySearchTree<T extends Comparable<T>> implements MyBinarySearchTreeInterface<T> {

	class Node {
		private T data;
		private Node leftChild;
		private Node rightChild;

		Node(T data) {
			this.data = data;
			leftChild = null;
			rightChild = null;
		}

		Node(T data, Node left, Node right) {
			this.data = data;
			leftChild = left;
			rightChild = right;
		}

	}

	private Node root;

	public Node getRoot() {
		return root;
	}

	private void insert(T element, Node currentNode) {
		if (isEmpty()) {
			root = new Node(element);
		} else if (currentNode.data.compareTo(element) < 0) { // currentNode.data
																// < element
			if (currentNode.rightChild == null) {
				Node temp = new Node(element, null, null);
				currentNode.rightChild = temp;
			} else {
				insert(element, currentNode.rightChild);
			}

		} else {
			if (currentNode.leftChild == null) {
				Node temp = new Node(element, null, null);
				currentNode.leftChild = temp;
			} else {
				insert(element, currentNode.leftChild);
			}
		}
	}

	@Override
	public void insert(T element) {
		insert(element, root);
	}

	private void print(Node root) {
		if (root != null) {
			print(root.leftChild);
			System.out.print(root.data + " ");
			print(root.rightChild);
		}

	}

	@Override
	public void print() {
		print(root);

	}

	private Node find(T element, Node currentNode) {
		if (currentNode == null) {
			return null;
		}
		if (currentNode.data.compareTo(element) == 0) {
			return currentNode;
		} else if (currentNode.data.compareTo(element) < 0) { // currentNode.data < element, we go right
			return find(element, currentNode.rightChild);
		} else {
			return find(element, currentNode.leftChild);
		}
	}

	@Override
	public Node find(T element) {
		return find(element, root);
	}

	private Node findParent(T element) {
		if (root == null) {
			return null;
		} else {
			return findParent(element, root);
		}
	}

	private Node findParent(T element, Node currentNode) {
		if (currentNode == null || isSearchedRightChild(element, currentNode)
				|| isSearchedLeftChild(element, currentNode)) {
			return currentNode;
		}

		if (element.compareTo(currentNode.data) < 0) { // element < currentNode.data
			return findParent(element, currentNode.leftChild);
		} else { // element > currentNode.data
			return findParent(element, currentNode.rightChild);
		}
	}

	private boolean isSearchedRightChild(T element, Node currentNode) {
		return currentNode.rightChild != null && currentNode.rightChild.data.compareTo(element) == 0;
	}

	private boolean isSearchedLeftChild(T element, Node currentNode) {
		return currentNode.leftChild != null && currentNode.leftChild.data.compareTo(element) == 0;
	}

	private boolean isLeaf(Node node) {
		return node.leftChild == null && node.rightChild == null;
	}

	private boolean hasOneChild(Node node) {
		return ((node.leftChild != null && node.rightChild == null)
				|| (node.rightChild != null && node.leftChild == null));
	}

	private Node smallestChild(Node node) {
		if (node.leftChild != null) {
			return smallestChild(node.leftChild);
		}

		return node;
	}

	public boolean isEmpty() {
		return root == null;
	}

	private void remove(T element, Node currentNode) {
		Node toBeRemoved = find(element, currentNode);
		if (toBeRemoved == null) {
			return;
		}
		Node parentNode = findParent(element);

		if (isLeaf(toBeRemoved)) { // the node to be removed has 0 children
			if (isSearchedLeftChild(element, parentNode)) {
				parentNode.leftChild = null;
			} else if (isSearchedRightChild(element, parentNode)) {
				parentNode.rightChild = null;
			}
		} else if (hasOneChild(toBeRemoved)) { // the node to be removed has 1 child
			if (toBeRemoved.leftChild != null && parentNode.leftChild == toBeRemoved) {
				parentNode.leftChild = toBeRemoved.leftChild;
			} else if (toBeRemoved.rightChild != null && parentNode.leftChild == toBeRemoved) {
				parentNode.leftChild = toBeRemoved.rightChild;
			} else if (toBeRemoved.leftChild != null && parentNode.rightChild == toBeRemoved) {
				parentNode.rightChild = toBeRemoved.leftChild;
			} else if (toBeRemoved.rightChild != null && parentNode.rightChild == toBeRemoved) {
				parentNode.rightChild = toBeRemoved.rightChild;
			}
		} else { // the node to be removed has 2 children
			Node smallestChild = smallestChild(toBeRemoved.rightChild);
			toBeRemoved.data = smallestChild.data;

			Node smallestChildParent = findParent(smallestChild.data);
			smallestChildParent.leftChild = smallestChild.rightChild;
		}
	}

	@Override
	public void remove(T element) {
		remove(element, root);
	}

	public static void main(String[] args) {

		MyBinarySearchTree<Integer> t = new MyBinarySearchTree<>();
		t.insert(15);
		t.insert(9);
		t.insert(18);
		t.insert(4);
		t.insert(10);
		t.insert(16);
		t.insert(30);
		t.insert(5);

		t.print();

		t.remove(5);
		System.out.println();
		t.print();

	}

}
