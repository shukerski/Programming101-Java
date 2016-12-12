package com.week03.thursday;

public interface MyLinkedListInterface <T extends Comparable<T> >{
	public void addFirst(T element);
	
	public void addLast(T element);
	
	public void add(T newElement, int index);
	
	public T getFirst();
	
	public T getLast();
	
	public T get(int index);
	
	public int getSize();
	public boolean empty();
	
	public void remove(int index);
	
	public void addList(MyLinkedListInterface<T> list);
	
	
}
