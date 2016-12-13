package com.week08.tuesday.DungeonsAndZombies;

public abstract class Entity {
	
	String name;

	protected int maxHealth;
	protected int currentHealth;
	protected int mana;
	protected int currentMana;

	protected Weapon currentWeapon;
	protected Spell currentSpell;
	
	public Entity(int health, int mana) {
		this.maxHealth = health;
		this.currentHealth = health;
		this.mana = mana;
		this.currentMana = mana;
		
	}

	public int getHealth() {
		return currentHealth;
	}

	public void setHealth(int health) {
		this.currentHealth = health;
	}

	public int getMana() {
		return currentMana;
	}

	public void setMana(int mana) {
		this.currentMana = mana;
	}
	
	public boolean isAlive() {
		return currentHealth > 0;
	}
	
	public boolean canCast() {
		return currentMana > currentSpell.manaCost;
	}
	
	public void takeDamage(int damagePoints) {
		if(damagePoints > currentHealth) {
			currentHealth = 0;
		}
		
		currentHealth -= damagePoints;
	}
	
	public void takeHealing(int healingPoints) {
		if(currentHealth + healingPoints > maxHealth) {
			currentHealth = maxHealth;
		}
		
		currentHealth += healingPoints;
	}
	
	public void loseMana(int lostMana) {
		if(currentMana <= lostMana) {
			currentMana = 0;
		}
		else {
			currentMana -= lostMana;
		}
	}
	
	public void equip(Weapon weapon) {
		currentWeapon = weapon;
	}
	
	public void learnSpell(Spell spell) {
		currentSpell = spell;
	}
	
	public abstract int attack(String damageDealer);
}
