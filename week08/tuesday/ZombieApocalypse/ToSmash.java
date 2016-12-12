package com.week08.tuesday.ZombieApocalypse;

public class ToSmash extends Weapon{
	
	int maxDurability;
	
	public ToSmash(int damage, int durability) {
		super(damage, durability);
		maxDurability = durability;
	}
	
	public int hit() {
		if(durability > 0 && durability >= maxDurability/2) {
			durability--;
			return damage;
		}
		if(damage > 1) {
			damage--;
		}
		return damage;
	}
}
