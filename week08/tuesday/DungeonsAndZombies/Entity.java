package com.week08.tuesday.DungeonsAndZombies;

public abstract class Entity {
	
	protected String name;
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
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getMaxHealth() {
		return maxHealth;
	}



	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}



	public int getCurrentHealth() {
		return currentHealth;
	}



	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}



	public int getMana() {
		return mana;
	}



	public void setMana(int mana) {
		this.mana = mana;
	}



	public int getCurrentMana() {
		return currentMana;
	}



	public void setCurrentMana(int currentMana) {
		this.currentMana = currentMana;
	}



	public Weapon getCurrentWeapon() {
		return currentWeapon;
	}



	public void setCurrentWeapon(Weapon currentWeapon) {
		this.currentWeapon = currentWeapon;
	}



	public Spell getCurrentSpell() {
		return currentSpell;
	}



	public void setCurrentSpell(Spell currentSpell) {
		this.currentSpell = currentSpell;
	}



	public boolean isAlive() {
		return currentHealth > 0;
	}
	
	
	public boolean canCast() {
		return currentMana > currentSpell.getManaCost();
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
