package com.capgemini.alewandowski.entities;

import java.util.List;

import com.capgemini.alewandowski.ENUMS.LEVEL;


public class User {
	private int userId;
	private String firstName;
	private String lastName;
	private String emailAddres;
	private String password;
	private int age;
	private String lifeMotto;
	private int currentLevelPoints;
	private LEVEL currentLevel;
	//List<PlayerGameStats> listOfGames;
	//List<Aviaibilty> availabilityHours;
	
	// Constructors
	public User(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getCurrentLevelPoints() {
		return currentLevelPoints;
	}
	public void setCurrentLevelPoints(int currentLevelPoints) {
		this.currentLevelPoints = currentLevelPoints;
	}
	public LEVEL getCurrentLevel() {
		return currentLevel;
	}
	public void setCurrentLevel(LEVEL currentLevel) {
		this.currentLevel = currentLevel;
	}
//	public List<PlayerGameStats> getListOfGames() {
//		return listOfGames;
//	}
//	public void setListOfGames(List<PlayerGameStats> listOfGames) {
//		this.listOfGames = listOfGames;
//	}
//	public List<Avaibility> getAvailabilityHours() {
//		return availabilityHours;
//	}
//	public void setAvailabilityHours(List<Integer> availabilityHours) {
//		this.availabilityHours = availabilityHours;
//	}


	
	
	
	

}
