package com.week02.thursday;

import java.util.Scanner;

//	f1(x) = f2(x) + f3(x)
//	f2(x) = 2 * x
//	f3(x) = x + 1
//	f4(x) = 2 * f1(x)
public class FunctionCalls { // Parser

	public static int evaluate(String formula, int x) {
	    String[] functions = formula.replaceAll("\\s+", "").split("\\.");
	    for(int i = functions.length - 1; i >= 0; i--) {
	    	if(functions[i].equals("f1")) {
	    		x  = f1(x);
	    	}
	    	
	    	if(functions[i].equals("f2")) {
	    		x  = f2(x);
	    	}
	    	
	    	if(functions[i].equals("f3")) {
	    		x  = f3(x);
	    	}
	    	
	    	if(functions[i].equals("f4")) {
	    		x  = f4(x);
	    	}
	    }
	    return x;
	  }
	
	public static int f1(int x) {
		return f2(x) + f3(x);
	}
	
	public static int f2(int x) {
		return 2*x;
	}
	
	public static int f3(int x) {
		return x+1;
	}
	
	public static int f4(int x) {
		return 2*f1(x);
	}
	
	public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String input = scanner.nextLine();
    int x = scanner.nextInt();
    
    System.out.println(evaluate(input, x));

    }

}
