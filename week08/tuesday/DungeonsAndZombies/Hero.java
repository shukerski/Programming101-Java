package com.week08.tuesday.DungeonsAndZombies;

public class Hero extends Entity{
	private String name;
	private String title;
	private Position position;
	private int manaRegenRate;
	
	public Position getPosition() {
		return position;
	}
	
	public int getXPosition() {
		return position.x;
	}
	
	public int getYPosition() {
		return position.y;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Hero(String name, String title, int health, int mana, int manaRegenRate) {
		super(health, mana);
		this.name = name;
		this.title = title;
		this.manaRegenRate = manaRegenRate;
	}

	public String knownAs() {
		return name + " the " + title;
	}
	
	public void takeMana(int manaPoints) {
		currentMana += manaPoints;
	}

	@Override
	public int attack(String damageDealer) {
		if(damageDealer.equals("weapon") && currentWeapon == null) {
			return 0;
		}
		
		if(damageDealer.equals("spell") && currentSpell == null) {
			return 0;
		}
		
		if(damageDealer.equals("weapon")) {
			return currentWeapon.getDamage();
		} else {
			this.loseMana(currentSpell.getManaCost());
			return currentSpell.getDamage();
		}
	}
	
	
	
	
	
}
