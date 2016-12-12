package com.week07.thursday;

public class Panda {
	
	private String name;
	private String email;
	private String gender;
	
	public Panda(String name, String email, String gender) {
		this.name = name;
		if(validEmail(email)) {
			this.email = email;
		}
		this.gender = gender;
	}
	
	private boolean validEmail(String email) {
		return email.matches("\\s+@\\s+\\.\\s+");
	}
	
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if(validEmail(email)) {
			this.email = email;
		}
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public boolean isMale() {
		return this.gender.compareTo("male") == 0;
	}
	
	public boolean isFemale() {
		return this.gender.compareTo("female") == 0;
	}
	
}
