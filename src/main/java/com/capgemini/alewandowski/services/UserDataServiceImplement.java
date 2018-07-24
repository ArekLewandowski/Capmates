package com.capgemini.alewandowski.services;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.capgemini.alewandowski.interfaces.UserDataService;

import com.capgemini.alewandowski.ENUMS.LEVEL;
import com.capgemini.alewandowski.entities.Game;
import com.capgemini.alewandowski.entities.User;


public class UserDataServiceImplement implements UserDataService{

	private int users;
	private List<User> usersList;
	
	

	public UserDataServiceImplement() {
		super();
		this.users = 0;
		this.usersList = new LinkedList<>();
		System.out.println("User service");
	}
	
	@PostConstruct
	public void test(){
		System.out.println("User manager podniesiony");
	}
	

	public int getUsers() {
		return users;
	}


	public List<User> getUsersList() {
		return usersList;
	}


	public void setUsersList(List<User> usersList) {
		this.usersList = usersList;
	}



	@Override
	public User addNewUser(String firstName, String lastName) {
		User newUser = new User(firstName, lastName);
		newUser.setUserId(this.users);
		newUser.setCurrentLevelPoints(0);
		newUser.setCurrentLevel(LEVEL.NOVICE);
		this.usersList.add(newUser);
		this.users++;
		
		return newUser;
	}

	@Override
	public User changeUserData(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User vievInforamtion(int userId) {
		User user = this.usersList.get(userId-1);
		System.out.println("Id : "+user.getUserId());
		System.out.println("First Name : "+user.getFirstName());
		System.out.println("Last Name : "+user.getLastName());
		System.out.println("Level overall: "+user.getCurrentLevel());
		System.out.println("Level points overall: "+user.getCurrentLevelPoints());
		return user;
	}

	@Override
	public int checkPoints(int userId) {
		int points = this.usersList.get(userId).getCurrentLevelPoints();
		return points;
	}

	@Override
	public LEVEL checkLevel(int userId) {
		LEVEL level = this.usersList.get(userId).getCurrentLevel();
		return level;
	}


	@Override
	public List<User> checkRanking() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Game> checkPlayersGames(int userId) {
		List<Game> games = new ArrayList<>();
		
		return games;
	}

}
