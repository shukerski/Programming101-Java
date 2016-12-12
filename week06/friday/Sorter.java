package com.week06.friday;

public class Sorter {
	
	public static void selectionSort(int[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			int currentMin = i;
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[j] < arr[currentMin]) {
					currentMin = j;
				}
			}
			// swap
			int temp = arr[currentMin];
			arr[currentMin] = arr[i];
			arr[i] = temp;
		}
	}
	
	public static void insertionSort(int[] arr) {
		int temp;
		for(int i = 1; i < arr.length; i++) {
			for(int j = i; j > 0; j--) {
				if(arr[j] < arr[j-1]) {
					temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
			}
		}
	}
	
	public static void bubbleSort(int[] arr) {
		boolean swapped = true; // for the first iteration
		int temp;
		while(swapped) {
			swapped = false;
			for(int i = 1; i < arr.length; i++) {
				if(arr[i-1] > arr[i]) {
					temp = arr[i];
					arr[i] = arr[i-1];
					arr[i-1] = temp;
					swapped = true;
				}
			}
		}
	}
	
	public static void countingSort(int[] arr) {
		int maxElement = arr[0];
		int minElement = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if(arr[i] > maxElement) {
				maxElement = arr[i];
			}
			if(arr[i] < minElement) {
				minElement = arr[i];
			}
		}
		
		int[] histogram = new int[maxElement - minElement + 1];
		for (int i = 0; i < arr.length; i++) {
			histogram[arr[i] - minElement]++;
		}
		
//		System.out.println();
//		for (int i = 0; i < histogram.length; i++) {
//			System.out.print(histogram[i] + " ");
//		}
		
		int index=0;
		for (int i = 0; i < histogram.length; i++) {
			for(int j = 0; j < histogram[i]; j++) {
				arr[index] = i + minElement;
				index++;
			}
		}
		
		
	}
	public static void main(String[] args) {

		int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
		selectionSort(arr);
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		int[] arr2 = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
		insertionSort(arr2);
		
		System.out.println();
		
		for(int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
		
		int[] arr3 = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
		bubbleSort(arr3);
		
		System.out.println();
		
		for(int i = 0; i < arr3.length; i++) {
			System.out.print(arr3[i] + " ");
		}
		
		int[] arr4 = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
		countingSort(arr4);
		
		System.out.println();
		
		for(int i = 0; i < arr4.length; i++) {
			System.out.print(arr4[i] + " ");
		}
	}

}
