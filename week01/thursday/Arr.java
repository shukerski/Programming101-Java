package com.week01.thursday;

public class Arr {
	  public static String toString(int[] a) {
	    String result = "";
	    for (int i = 0; i < a.length;i++) {
	      result += a[i];
	      if(i < a.length - 1){
	        result += ", ";
	      }
	    }
	    return result;
	  }
	  
	  public static void sort(int[] a) {
	    boolean swapped = true;
	    int lowerBound = 0;
	    int temp;
	    while(swapped) {
	      swapped = false;
	      lowerBound++;
	      for(int i = 0; i < a.length - lowerBound; i++) {
	        if (a[i] > a[i+1]) {
	          temp = a[i];
	          a[i] = a[i+1];
	          a[i+1] = temp;
	          swapped = true;
	        }
	      }
	    }
	  }
	  
	  // TODO: Other implementation which is "In Place" with temporary variable
	  public static int[] reverse(int[] a) {
	    int[] result = new int[a.length];
	    for (int i = 0; i < a.length; i++) {
	      result[a.length - i - 1] = a[i];
	    }
	    return result;
	  }
	  
	  public static String join(int[] a, String glue) {
	    String result = "";
	    for (int i = 0; i < a.length; i++) {
	      result += a[i];
	      if(i < a.length - 1){
	        result += glue;
	      }
	    }
	    return result;
	  }
	  
	  public static int sum(int[] a) {
	    int result = 0;
	    for (int i = 0; i < a.length; i++ ) {
	      result += a[i];
	    }
	    return result;
	  }
	  
	  public static int[] range(int a, int b) {
	    int length = Math.abs(b - a);
	    int[] result = new int[length];
	    for (int i = 0; i < length; i++ ) {
	      result[i] = a;
	      a++;
	    }
	    return result;
	  }
	  
	  public static int oddCount(int[] a) {
	    int counter = 0;
	    for(int i = 0; i < a.length; i++) {
	      if (a[i] % 2 != 0) {
	        counter++;
	      }
	    }
	    return counter;
	  }
	  public static int[] filterOdd(int[] a) {
	    int count = oddCount(a);
	    int[] result = new int[count];
	    int j = 0;
	    for (int i = 0; i < a.length; i++) {
	      if(a[i] % 2 != 0){
	        result[j] = a[i];
	        j++;
	      }
	    }

	    return result;
	  }
	  
	  public static void main(String[] args) {
	    // int[] a = {10, 20, -50, 80, 70, 66, -365};
	    // int [] a = {2,3,4,8,9,11,13,15};

	    // System.out.println("Print the array to string:");
	    // System.out.println(Arr.toString(a));
	    
	    // System.out.println("Sort the array a itself and print it sorted:");
	    // Arr.sort(a);
	    // System.out.println(Arr.toString(a));

	      int [] a = {3,1,-40,200,5};
	      Arr.sort(a);
	      System.out.println(Arr.toString(a));
	    
	    
	    // System.out.println("Print the reverse of the sorted array");
	    // a = Arr.reverse(a);
	    // System.out.println(Arr.toString(a));
	    
	    // System.out.println("Output each element in a with -> between them");
	    // System.out.println(Arr.join(a, "->"));
	    
	    // System.out.println("Output the sum");
	    // int b = Arr.sum(a);
	    // System.out.println(b);
	    
	    // System.out.println("Output array with elements from 1 to 10");
	    // System.out.println(Arr.toString(Arr.range(1, 10)));
	    
	    // System.out.println("Print only the odd numbers");
	    // int[] temp = Arr.filterOdd(a);
	    // System.out.println(Arr.join(temp, ", "));

	  }
	}