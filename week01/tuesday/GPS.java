package com.week01.tuesday;

import java.util.*;

public class GPS {

  public static ArrayList<Integer> getGasStations(int tripDistance, int tankSize, ArrayList<Integer> gasStations) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    int current = 0; // the current gas station (position)

    while(current + tankSize < tripDistance){
      for (int i = gasStations.size() - 1;i >= 0 ;i--) {
        if (gasStations.get(i) <= current + tankSize) {
          result.add(gasStations.get(i));
          current = gasStations.get(i);
          break;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int tripDistance = scanner.nextInt();
    int tankSize = scanner.nextInt();

    int gasStationsCount = scanner.nextInt();
    ArrayList<Integer> gasStations = new ArrayList<Integer>();

    for (int i = 0; i < gasStationsCount; i++) {
      gasStations.add(scanner.nextInt());
    }

    ArrayList<Integer> result = getGasStations(tripDistance, tankSize, gasStations);

    for (int i = 0; i < result.size(); i++) {
        System.out.println(result.get(i));
    }

  }
}