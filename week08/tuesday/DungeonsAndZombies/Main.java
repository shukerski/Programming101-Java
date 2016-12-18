package com.week08.tuesday.DungeonsAndZombies;

public class Main {

	public static void main(String[] args) {
		
		Hero h = new Hero("Bron", "Dragonslayer", 100, 100, 2);
		Weapon w = new Weapon("The Axe of Destiny", 20);

		h.equip(w);

//		System.out.println(h.attack("weapon"));
		
		String[][] map = {
				{".",".","#","#",".",".",".",".",".","T"},
				{"#","T","#","#",".",".","#","#","#","."},
				{"#",".","#","#","#","E","#","#","#","E"},
				{"#",".","#",".",".",".","#","#","#","."},
				{"#","#","#","T","#","#","#","#","#","G"} };
		Dungeon d = new Dungeon(map, h);
//		Position position = d.getFirstAvailavblePosition();
		d.spawn(h);
		d.printMap();

//		System.out.println(position.x + " " + position.y);
//		System.out.println(map[position.x][position.y]);
		
	}
	

	
	
			
			
			
}
