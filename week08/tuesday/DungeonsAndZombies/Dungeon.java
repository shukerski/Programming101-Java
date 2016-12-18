package com.week08.tuesday.DungeonsAndZombies;

/*
 * 	String[][] map = {
		{"S",".","#","#",".",".",".",".",".","T"},
		{"#","T","#","#",".",".","#","#","#","."},
		{"#",".","#","#","#","E","#","#","#","E"},
		{"#",".","#",".",".",".","#","#","#","."},
		{"#","#","#","T","#","#","#","#","#","G"} };
		
    S means a starting point for our hero.
    G means gateway - the end of the dungeon (and most propably the enter to another)
    # is an obstacle
    . is a walkable path.
    T is a treasure that can be either mana, health, weapon or spell
    E is an enemy that our hero can fight

 */

public class Dungeon {
	private String[][] map;
	private Hero hero;
	
	
	public Dungeon(String[][] map, Hero hero) {
		this.map = map;
		this.hero = hero;
		// spawn hero
	}
	
	public void printMap() {
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

//	public Position getFirstAvailavblePosition() {
//		Position result = new Position(0,0);
//		for(int i = 0; i < map.length; i++) {
//			for(int j = 0; j < map[i].length; j++) {
//				if(map[i][j].equals(".")) {
//					result.x = i;
//					result.y = j;
//					break;
//				}
//			}
//		}
//		return result;
//	}
	
	public boolean spawn(Hero hero) { // it can return the position at which the hero is spawned
		this.hero = hero;
		Position availablePosition = new Position(0, 0);
		this.hero.setPosition(availablePosition);
		map[hero.getXPosition()][hero.getYPosition()] = "H";
		return true;
	}
	
	public void moveHero(String direction) {
		switch (direction) {
		case "down":
			//some code
			break;
		case "up":
			// some code
			break;
		case "left":
			// some code
			break;
		case "right":
			// some code
			break;

		default:
			break;
		}
	}
}
