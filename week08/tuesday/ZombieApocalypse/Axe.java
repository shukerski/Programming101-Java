package com.week08.tuesday.ZombieApocalypse;

public class Axe extends ToSmash{

	public Axe() {
		super(10, 50); // calling the constructor of the parent
	}
	
	public String toString() {
		return "Axe" + damage + " " + durability;
	}
}
