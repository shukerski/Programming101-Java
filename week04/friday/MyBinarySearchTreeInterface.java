package com.week04.friday;

import com.week04.friday.MyBinarySearchTree.Node;

public interface MyBinarySearchTreeInterface <T> {
	
	public void insert(T element);
	
	public void print();
	
	public void remove(T element);
	
	public Node find(T element);

}
