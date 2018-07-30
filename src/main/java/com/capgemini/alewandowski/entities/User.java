package com.capgemini.alewandowski.entities;

public class User {
	private int userId;
	private String firstName;
	private String lastName;
	private String emailAddres;
	private String password;
	private String lifeMotto;

	// Constructors
	public User() {
		super();
	}
	
	public User(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public User(int id, String firstName, String lastName) {
		super();
		this.userId = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	
	
	public User(int userId, String firstName, String lastName, String emailAddres, String password, String lifeMotto) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddres = emailAddres;
		this.password = password;
		this.lifeMotto = lifeMotto;
	}

	//Getters and Setters
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAddres() {
		return emailAddres;
	}
	public void setEmailAddres(String emailAddres) {
		this.emailAddres = emailAddres;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLifeMotto() {
		return lifeMotto;
	}
	public void setLifeMotto(String lifeMotto) {
		this.lifeMotto = lifeMotto;
	}


}
