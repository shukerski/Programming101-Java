package com.week05.tuesday;

/*
 * system stack, frame, overflow
 */
public class RecursionTest {
	private static long level = 0;
	
	public static void main(String[] args) {
		recur();
	}
	
	public static void recur() { // no bottom for the recursion - the system stack will overflow
		level++;
		System.out.println(level);
		recur();
		
//		8769 - stack overflow
	}
}
