package com.capgemini.alewandowski.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.alewandowski.ENUMS.LEVEL;
import com.capgemini.alewandowski.entities.User;
import com.capgemini.alewandowski.entities.UserStats;
import com.capgemini.alewandowski.interfaces.UserDataService;
import com.capgemini.alewandowski.repositories.UserBasicDAOImpl;
import com.capgemini.alewandowski.repositories.UserStatsDAOImpl;

@Service
public class UserDataServiceImpl implements UserDataService{

	@Autowired
	UserBasicDAOImpl userBasicDAO;
	
	@Autowired
	UserStatsDAOImpl userStatsDAO;
	
	private int users;	
	

	public UserDataServiceImpl() {
		super();
		this.users = 0;
		System.out.println("User service");
	}
	
	public int getUsers() {
		return users;
	}
	
	@Override
	public User addNewUser(String firstName, String lastName) {
		User newUser = new User(firstName, lastName);
		newUser.setUserId(users);
		UserStats userStats = new UserStats();
		userStats.setUserId(this.users);
		userStats.setCurrentLevelPoints(0);
		userStats.setCurrentLevel(LEVEL.NOVICE);
		
		userBasicDAO.addUser(newUser);
		userStatsDAO.addNewUser(userStats);
		this.users++;		
		return newUser;
	}

	@Override
	public User changeUserData(int userId,
			String firstName, 
			String lastName, 
			String email, 
			String password, 
			String lifeMotto) {
		User editedUser = userBasicDAO.getUser(userId);
		editedUser.setFirstName(firstName);
		editedUser.setLastName(lastName);
		editedUser.setEmailAddres(email);
		editedUser.setPassword(password);
		editedUser.setLifeMotto(lifeMotto);
		return editedUser;
	}
	@Override
	public void viewInforamtion(int userId) {
		User user = userBasicDAO.getUser(userId);
		System.out.println("Id: "+user.getUserId());
		System.out.println("First Name: "+user.getFirstName());
		System.out.println("Last Name: "+user.getLastName());
		System.out.println("Email: "+user.getEmailAddres());
		System.out.println("Life motto: "+user.getLifeMotto());
	}

	@Override
	public void deleteUser(int userId) {
		userBasicDAO.deleteUser(userId);
		userStatsDAO.deleteStatsOfUser(userId);
	}
	
}
