package com.week08.tuesday.DungeonsAndZombies;

public class Enemy extends Entity{
	
	int initialDamage;
	
	public Enemy(int health, int mana, int damage) {
		super(health, mana);
		initialDamage = damage;
	}

	@Override
	public int attack(String damageDealer) {
		if(currentWeapon == null || currentSpell == null) {
			return initialDamage;
		}
		if(damageDealer.equals("weapon")) {
			return currentWeapon.damage;
		} else {
			this.loseMana(currentSpell.manaCost);
			return currentSpell.damage;
		}
	}

}
