package com.week04.thursday;

/**
 * Stack interface
 * 
 * @author dimitar
 *
 * @param <T> should implement the Comparable interface
 */
public interface MyStackInterface<T extends Comparable<T> > {
	
	/**
	 * Removes the element on the top of the stack.
	 * 
	 * @return the element on the top of the stack
	 */
	public T pop();
	
	/**
	 * Adds an element on the top of the stack
	 * @param element
	 */
	public void push(T element);
	
	/**
	 * Returns the element on the top of the stack.
	 * @return
	 */
	
	public T peek();
	
	/**
	 * 
	 * @return the number of elements in the stack
	 */
	public int getSize();
	
	public boolean isEmpty();
	
}
