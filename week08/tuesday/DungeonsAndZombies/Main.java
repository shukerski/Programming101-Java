package com.week08.tuesday.DungeonsAndZombies;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Hero h = new Hero("Bron", "Dragonslayer", 100, 100, 2);
		Weapon w = new Weapon("The Axe of Destiny", 20);

		h.equip(w);

//		System.out.println(h.attack("weapon"));
		
		String[][] map = {
				{"S",".","#","#",".",".",".",".",".","T"},
				{"#","T","#","#",".",".","#","#","#","."},
				{"#",".","#","#","#","E","#","#","#","E"},
				{"#",".","E","T","T",".","#","#","#","."},
				{"#","#","#","T","#","#","#","#","#","G"} };
		Dungeon d = new Dungeon(map, h);
		
		d.spawn(h);
		String nextMove = "";
		Scanner s = new Scanner(System.in);
		d.printMap();
		while(true) {
			System.out.println("Where do you want to go? up/down/left/right ?");
			nextMove = s.next();
			d.moveHero(nextMove);
			d.printMap();
		}

	}
	

	
	
			
			
			
}
