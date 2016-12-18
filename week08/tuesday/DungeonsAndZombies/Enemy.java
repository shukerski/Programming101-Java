package com.week08.tuesday.DungeonsAndZombies;

public class Enemy extends Entity{
	
	private int initialDamage;
	
	public int getInitialDamage() {
		return initialDamage;
	}

	public void setInitialDamage(int initialDamage) {
		this.initialDamage = initialDamage;
	}

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
			return currentWeapon.getDamage();
		} else {
			this.loseMana(currentSpell.getManaCost());
			return currentSpell.getDamage();
		}
	}

}
