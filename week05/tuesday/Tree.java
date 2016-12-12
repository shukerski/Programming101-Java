package com.week05.tuesday;

public class Tree {

	private Node root;
	
	private class Node {
		private int element;
		private Node left;
		private Node right;
		
		public Node(int element) {
			this.element = element;
		}
	}
	
	public void insert(int newElement) {
		if(root == null) {
			root = new Node(newElement);
		} else {
			insertRecursive(newElement, root);
		}
	}
	
	private void insertRecursive(int newElement, Node currentNode) {
		if (newElement < currentNode.element) {
			if(currentNode.left == null) {
				currentNode.left = new Node(newElement);
			} else {
				insertRecursive(newElement, currentNode.left);
			}
		} else if (newElement > currentNode.element){
			if(currentNode.right == null) {
				currentNode.right = new Node(newElement);
			}  else {
				insertRecursive(newElement, currentNode.right);
			} 
		}
	}
	
	public void remove(int target) {
		
		Node targetNode = findNodeRecursive(target, root);
		if(targetNode == null) {
			return;
		}
		Node parentNode = findParent(target);
		
		
		if(isLeaf(targetNode)) { // case 0 children
			handleZeroChildrenCase(target, parentNode);
		} else if (hasOneChild(targetNode)) { // case 1 child
			handleOneChildCase(targetNode, parentNode);
			
		} else { // case 2 children
			handleTwoChildrenCase(targetNode);
		}
	}

	private void handleTwoChildrenCase(Node targetNode) {
		Node smallestChild = getSmallestChild(targetNode.right);
		targetNode.element = smallestChild.element;
		
		Node smallestChildParent = findParent(smallestChild.element);
		smallestChildParent.left = smallestChild.right;
	}

	private void handleOneChildCase(Node targetNode, Node parentNode) {
		if(targetNode.left != null && parentNode.left == targetNode) {
			parentNode.left = targetNode.left;
		} else if(targetNode.right != null && parentNode.left == targetNode) {
			parentNode.left = targetNode.right;
		} else if(targetNode.left != null && parentNode.right == targetNode) {
			parentNode.right = targetNode.left;
		} else if(targetNode.right != null && parentNode.right == targetNode) {
			parentNode.right = targetNode.right;
		}
	}

	private void handleZeroChildrenCase(int target, Node parentNode) {
		if(checkLeftChild(parentNode, target)) {
			parentNode.left = null;
		} else if(checkRightChild(parentNode, target)) {
			parentNode.right = null;
		}
	}
	
	private boolean isLeaf(Node node) {
		return node.left == null && node.right == null;
	}
	
	private Node getSmallestChild(Node currentNode) {
		if(currentNode.left != null) {
			return getSmallestChild(currentNode.left);
		}
		
		return currentNode;
	}
	
	private boolean hasOneChild(Node targetNode) {
		return((targetNode.left != null && targetNode.right == null) || 
				(targetNode.right != null && targetNode.left == null));
	}
	
	private int removeSmallestChild(Node node) {
		if(node.left == null) {
			return node.element;
		}	
		return 0;
	}

	private Node findParent(int target) {
		if(root == null) {
			return null;
		} else {
			return findParentRecursive(target, root);
		}
	}
	
	private Node findNodeRecursive(int target, Node currentNode) {
		if(root == null || currentNode == null) {
			return null;
		} else if (currentNode.element == target) {
			return currentNode;
		}
		
		if(target < currentNode.element) {
			return findNodeRecursive(target, currentNode.left);
		}
		else {
			return findNodeRecursive(target, currentNode.right);
		}
	}
	
	private Node findParentRecursive(int target, Node currentNode) {

		if(currentNode == null || checkLeftChild(currentNode, target) || checkRightChild(currentNode, target)) {
			return currentNode;
			// think about null calls
		}
		
		if(target < currentNode.element) {
			return findParentRecursive(target, currentNode.left);
		} else {
			return findParentRecursive(target, currentNode.right);
		}
	}
	
	private boolean checkRightChild(Node node, int target) {
		return (node.right != null && node.right.element == target);
	}
	
	private boolean checkLeftChild(Node node, int target) {
		return (node.left != null && node.left.element == target);
	}
	public static void main(String[] args) {
		System.out.println("test");
	}
}

