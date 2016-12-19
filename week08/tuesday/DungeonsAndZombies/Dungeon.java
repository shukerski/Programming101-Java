package com.week08.tuesday.DungeonsAndZombies;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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
	private Position heroPosition;
	
	public Dungeon(String[][] map, Hero hero) {
		this.map = map;
		this.hero = hero;
	}
	
	public Position getHeroPosition() {
		return heroPosition;
	}

	public void setHeroPosition(Position heroPosition) {
		this.heroPosition = heroPosition;
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

	
	public boolean spawn(Hero hero) {	
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				if(map[i][j].equals("S")) {
					heroPosition = new Position(i,j);
					map[i][j] = "H";
					return true;
				}
			}
		}
		return false;
	}
	
	private Spell pickSpell(String fileName) {
		Spell result;
		String line = "";
		Random rand = new Random();
		int n = rand.nextInt(4); // 4 is the number of spells in spells.txt // ??? exclusive interval
		try {
			FileReader inputFile = new FileReader(fileName);
			BufferedReader bufferReader = new BufferedReader(inputFile);
			for(int i = 0; i < n; i++) {
				bufferReader.readLine();
			}
			line = bufferReader.readLine();
			bufferReader.close();
			
		} catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		String attributes[] = line.split(",");
		int damage = Integer.parseInt(attributes[1]);
		int manaCost = Integer.parseInt(attributes[2]);
		int range = Integer.parseInt(attributes[3]);
		result = new Spell(attributes[0],damage,manaCost,range);
		return result;
		
	}
	
	private Weapon pickWeapon(String fileName) {
		Weapon result;
		String line = "";
		Random rand = new Random();
		int n = rand.nextInt(3); // 3 is the number of weapons in weapons.txt
		try {
			FileReader inputFile = new FileReader(fileName);
			BufferedReader bufferReader = new BufferedReader(inputFile);
			for(int i = 0; i < n; i++) {
				bufferReader.readLine();
			}
			line = bufferReader.readLine();
			bufferReader.close();
			
		} catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		String attributes[] = line.split(",");
		int damage = Integer.parseInt(attributes[1]);
		result = new Weapon(attributes[0],damage);
		return result;
	}
	
	private Potion pickPotion(String fileName) {
		Potion result;
		String line = "";
		Random rand = new Random();
		int n = rand.nextInt(3); // 3 is the number of potions in potions.txt
		try {
			FileReader inputFile = new FileReader(fileName);
			BufferedReader bufferReader = new BufferedReader(inputFile);
			for(int i = 0; i < n; i++) {
				bufferReader.readLine();
			}
			line = bufferReader.readLine();
			bufferReader.close();
			
		} catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		String attributes[] = line.split(",");
		int healingPoints = Integer.parseInt(attributes[1]);
		int manaPoints = Integer.parseInt(attributes[2]);
		result = new Potion(attributes[0], healingPoints, manaPoints);
		return result;
	}
	
	private void pickTreasure(int number) {
		Scanner scanner = new Scanner(System.in);
		String response = "";
		switch(number) {
		case 0:
			System.out.println("You found a potion!");
			Potion potion = pickPotion("/home/dimitar/Coding/HackBulgaria/Programming101Java/src/com/week08/tuesday/DungeonsAndZombies/Levels/1/Treasures/potions.txt");
			System.out.println("It is " + potion.getName() + " and it gives you " 
									    + potion.getHealingPoints() + " healing points and "
									    + potion.getManaPoints() + " mana points!");
			hero.takeHealing(potion.getHealingPoints());
			hero.takeMana(potion.getManaPoints());
			break;
		case 1:
			System.out.println("You found a weapon!");
			Weapon weapon = pickWeapon("/home/dimitar/Coding/HackBulgaria/Programming101Java/src/com/week08/tuesday/DungeonsAndZombies/Levels/1/Treasures/weapons.txt");
			System.out.println("It is " + weapon.getName() + " and it's damage is " + weapon.getDamage());
			if(hero.getCurrentWeapon() == null) {
				System.out.println("You don't have a weapon.");
			} else {
				System.out.println("Your current weapon is " + hero.getCurrentWeapon().getName() + " with damage " + hero.getCurrentWeapon().getDamage());
			}
			System.out.println("Do you want the new weapon you found? y/n");
			response = scanner.nextLine();
			if(response.equals("y") || response.equals("yes")) {
				hero.equals(weapon);
				System.out.println(weapon.getName() + " equipped");
			}
			break;
		case 2:
			System.out.println("You found a spell!");
			Spell spell = pickSpell("/home/dimitar/Coding/HackBulgaria/Programming101Java/src/com/week08/tuesday/DungeonsAndZombies/Levels/1/Treasures/spells.txt");
			System.out.println("It is " + spell.getName() 
										+ " it's damage is " + spell.getDamage()
										+ " it's mana cost is " + spell.getManaCost()
										+ " it's casting range is " + spell.getCastRange());
			if(hero.getCurrentSpell() == null) {
				System.out.println("You haven't learned any spells yet.");
			} else {
				
			System.out.println("Your current spell is " + hero.getCurrentSpell().getName() 
														+ " with damage " + hero.getCurrentSpell().getDamage()
														+ " with mana cost " + hero.getCurrentSpell().getManaCost()
														+ " with casting range " + hero.getCurrentSpell().getCastRange());
			}
			System.out.println("Do you want the new spell you found? y/n");
			response = scanner.nextLine();
			if(response.equals("y") || response.equals("yes")) {
				hero.learnSpell(spell);
				System.out.println(spell.getName() + " learned");
			}
			break;
		}
		scanner.close();
	}
	
	public void moveHero(String direction) {
		switch (direction) {
		case "down":
			if(map[heroPosition.getX() + 1][heroPosition.getY()].equals("#")) {
				System.out.println("You can't move down! There is an obsticle!");
			}
			if(heroPosition.getX() + 1 >= map.length) {
				System.out.println("You're trying to step into the unknown!");
			}
			if(map[heroPosition.getX() + 1][heroPosition.getY()].equals("T")) {
				Random rand = new Random();
				int n = rand.nextInt(3);
				pickTreasure(n);
			}
			if(map[heroPosition.getX() + 1][heroPosition.getY()].equals("E")) {
				//TODO fight starts
			}
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
		}
	}
}
