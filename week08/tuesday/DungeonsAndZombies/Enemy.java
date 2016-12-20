package com.week08.tuesday.DungeonsAndZombies;

public class Enemy extends Entity{
	
	private int initialDamage;
	
	public Enemy(int health, int mana, int damage) {
		super(health, mana);
		initialDamage = damage;
	}
	
	public int getInitialDamage() {
		return initialDamage;
	}

	public void setInitialDamage(int initialDamage) {
		this.initialDamage = initialDamage;
	}


	@Override
	public int attack(String damageDealer) {
		if(currentWeapon == null || currentSpell == null) {
			return initialDamage;
		}
		if(damageDealer.equals("weapon")) {
			return currentWeapon.getDamage();
		} else {
			return currentSpell.getDamage();
		}
	}

}
