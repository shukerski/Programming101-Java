package com.week05.tuesday;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Breakfast {

	private static int solve(Scanner sc) {
		int pancakesCount = sc.nextInt();
		int pansCount = sc.nextInt();

		// how much time is each pan takes to fry a pancake
		ArrayList<Integer> pans = new ArrayList<Integer>();
		for (int i = 0; i < pansCount; i++) {
			pans.add(sc.nextInt());
		}

		int minumimTime = calculateMinimumTime(pancakesCount, pansCount, pans);
		return minumimTime;

	}

	private static int calculateMinimumTime(int pancakesCount, int pansCount, ArrayList<Integer> pans) {
		int low = 0;
		int high = Collections.max(pans) * pancakesCount;
		while (low < high) {
			int mid = low + ((high - low) / 2);

			if (canCookPancakes(pancakesCount, pansCount, pans, mid)) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}

		return low;
	}

	private static boolean canCookPancakes(int pancakesCount, int pansCount, ArrayList<Integer> pans,
			int availableTime) {
		int cookedPancakes = 0;
		for (Integer pan : pans) {
			cookedPancakes += availableTime / pan;
		}
		return cookedPancakes >= pancakesCount;
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) { // try with resources, it
													// will close the resource,
													// instead of sc.close()
			int numberOfTests = sc.nextInt();
			for (int i = 0; i < numberOfTests; i++) {
				System.out.println(solve(sc));
			}
		}

	}
}
