package com.week04.thursday;


public class QueueWithTwoStacks {
	private MyStackInterface<Integer> in = new MyLinkedList<Integer>();
	private MyStackInterface<Integer> out = new MyLinkedList<Integer>();
	private int size;
	
	public void enqueue(int element) {
		in.push(element);
		size++;
	}
	
	public int dequeue() {
		if(out.isEmpty()) {
			while(!in.isEmpty()) {
				out.push(in.pop());
			}
		}
		int result = out.pop();
		size--;
		return result;
	}
	
	public int getSize() {
		return size;
	}
	
	public static void main(String[] args) {
		QueueWithTwoStacks q = new QueueWithTwoStacks();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		
		int size = q.getSize();
		for(int i = 0; i < size; i++) {
			System.out.println(q.dequeue());
		}
	}
	
}
/* Задача 1
 * 
 */

/* Задача 2
 * 
 */

/* Задача 3
 * Имаме 2 стека. Пресипваме от 1-ния в другия. Два стека и temp. Слагаме от 1-вия стек 1-вия елемент.
 * Ако следващия е < записваме го в temp. Връщаме от другия стек ония елемент(ако има повече
 * от 1 махаме докато не стане по-малко). Салгаме по-малкия. И така пак.
 * 
 * O(n^2) време и O(n) памет
 * 
 */

/* Задача 4
 *  ArrayList<Stack<T>>
 *  
 *  Имаме:
 *  
 *  _ _ _ _ _ _ _ _
 *  Имаме тези стекове. Те си имат ограничението колко елемента ще държат.
 *  Реално правим push и pop само в последния стек. Просто пазим къде е той,
 *  някакъв counter. 
 */




