package com.week08.tuesday.ZombieApocalypse;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int zombiesCount = input.nextInt();
		int zombiesHealth = input.nextInt();

		int counter = 0; // number of hits
		
		
		Axe axe = new Axe();
		
		HashMap<String, Weapon> weapons = new HashMap<>();
		weapons.put("Axe", new Axe());
		weapons.put("Shotgun", new Shotgun());
		weapons.put("Sword", new Sword());
		weapons.put("Revolver", new Revolver());
		
		Weapon weapon = weapons.get(input.next());
		
		for (int i = 0; i < zombiesCount; i++) {
			int oneZombieHealth = zombiesHealth;
			while(oneZombieHealth > 0) {
				oneZombieHealth -= weapon.hit();
				counter++;
			}
		}
		System.out.println(counter);
	}

}
