package com.week01.tuesday;

import java.util.Scanner;

public class Anagrams {

  public static boolean areAnagrams(String a, String b) {
    char [] aChars = a.toLowerCase().toCharArray(),
            bChars = b.toLowerCase().toCharArray();
    
    if(aChars.length != bChars.length) {
      return false;
    }

    int[] aCounts = new int[128];
    int[] bCounts = new int[128];

    for (int i = 0; i < aChars.length; i++) {
      aCounts[aChars[i]]++;
      bCounts[bChars[i]]++;
    }

    for (int i = 0; i <= 127; i++) {
      if (aCounts[i] != bCounts[i]) {
        return false;
      }
    }

      return true;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String a = scanner.next();
    String b = scanner.next();

    if (areAnagrams(a, b)) {
      System.out.println("ANAGRAMS");
    } else {
      System.out.println("NOT ANAGRAMS");
    }

  }
}