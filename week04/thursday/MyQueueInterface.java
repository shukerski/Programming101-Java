package com.week04.thursday;

/**
 * 
 * @author dimitar
 *
 * @param <T> should implement the Comparable interface
 */
public interface MyQueueInterface<T extends Comparable<T> > {

	/**
	 * Adds an element to the end of the queue.
	 * 
	 * @param the element to add
	 */
	public void enqueue(T element);
	
	/**
	 * Removes and returns the first element in the queue.
	 * 
	 * @return the first element in the queue
	 */
	public T dequeue();
	
	/**
	 * Returns the element on the top of the queue.
	 * @return
	 */
	
	public T peek();
	
	/**
	 * 
	 * @return the number of elements in the queue
	 */
	public int getSize();
	
	public boolean isEmpty();
}
