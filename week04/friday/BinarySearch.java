package com.week04.friday;

public class BinarySearch {

	// 1 2 5 8 11 15 20 25
	// left = 0, right = 7 -> len = 7
	// left = 3, right = 7 -> mid = 5
	public static int search(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;
		int indexOfTarget = -1; // if the element is not present we return -1
								// instead of exception

		while (left <= right) {
			// int mid = (left + right) / 2; // this is bad because the int could overflow
			int mid = left + ((right - left) / 2); // fix for the problem above

			if (arr[mid] == target) {
				indexOfTarget = mid; // return the index
				break;
			} else if (arr[mid] > target) {
				right = mid - 1; // we subtract 1, because we have checked the
									// mid and know it's not the target
			} else {
				left = mid + 1; // we add 1, because we have checked the mid and
								// know it's not the target
			}

		}

		return indexOfTarget;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 5, 8, 11, 15, 20, 25 };

		System.out.println(search(arr, 19));

	}

}
