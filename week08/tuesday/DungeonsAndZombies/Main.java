package com.week08.tuesday.DungeonsAndZombies;

public class Main {

	public static void main(String[] args) {
		
		Hero h = new Hero("Bron", "Dragonslayer", 100, 100, 2);
		Weapon w = new Weapon("The Axe of Destiny", 20);

		h.equip(w);

		System.out.println(h.attack("weapon"));

	}

}
