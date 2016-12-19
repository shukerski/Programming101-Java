package com.week08.tuesday.DungeonsAndZombies;

public class Potion {
	private String name;
	private int healingPoints;
	private int manaPoints;
	
	public Potion(String name, int healingPoints, int manaPoints) {
		this.name = name;
		this.healingPoints = healingPoints;
		this.manaPoints = manaPoints;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealingPoints() {
		return healingPoints;
	}

	public void setHealingPoints(int healingPoints) {
		this.healingPoints = healingPoints;
	}

	public int getManaPoints() {
		return manaPoints;
	}

	public void setManaPoints(int manaPoints) {
		this.manaPoints = manaPoints;
	}
	
	
}
