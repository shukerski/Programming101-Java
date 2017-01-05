package com.week10.tuesday.signatures;

import java.util.HashMap;
import java.util.Scanner;

public class SignaturesMain {

	public static void main(String[] args) {
		String line, composition;
		String[] lineParts, compositionParts;
		Scanner scanner = new Scanner(System.in);
		HashMap<String, Pair<String, String>> signatures = new HashMap<>();
		
		// Parsing the signatures into a HashMap
		while(true) {
			line = scanner.nextLine();
			if(line.equals("")) {
				break;
			}
			lineParts = line.split("\\s+");
			Pair<String, String> val = new Pair<String, String>(lineParts[2], lineParts[4]);
			signatures.put(lineParts[0], val);
		}
		// Parsing the composition
		composition = scanner.nextLine();
		compositionParts = composition.split("\\ . ");
		
		scanner.close();
		
		boolean correct = true;
		
		for (int i = compositionParts.length - 1; i > 0; i--) {
			if(!signatures.get(compositionParts[i]).getFirst().equals(signatures.get(compositionParts[i-1]).getSecond())) {
				correct = false;
			}
		}
		System.out.println(correct);

	}

}
