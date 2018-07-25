package com.capgemini.alewandowski.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.alewandowski.ENUMS.LEVEL;
import com.capgemini.alewandowski.entities.User;
import com.capgemini.alewandowski.entities.UserStats;
import com.capgemini.alewandowski.interfaces.UserDataService;
import com.capgemini.alewandowski.interfacesDAO.UserGamesDAO;
import com.capgemini.alewandowski.repositories.GamesDAOImpl;
import com.capgemini.alewandowski.repositories.UserBasicDAOImpl;
import com.capgemini.alewandowski.repositories.UserGamesDAOImpl;
import com.capgemini.alewandowski.repositories.UserStatsDAOImpl;

@Service
public class UserDataServiceImpl implements UserDataService{

	@Autowired
	private UserBasicDAOImpl userBasicDAO;
	
	@Autowired
	private UserStatsDAOImpl userStatsDAO;
	
	@Autowired
	private GamesDAOImpl gamesDAO;
	
	@Autowired
	private UserGamesDAOImpl userGamesDAO;
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
		
		userBasicDAO.addUser(newUser);
		userStatsDAO.addNewUserStats(userStats);
		this.users++;		
		return newUser;
	}

	@Override
	public User changeUserData(User user) {
		User editedUser = userBasicDAO.editUser(user.getUserId(), user);
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

	@Override
	public List<String> getUsersGameList(int userId) {		
		List<Integer> userGames = userGamesDAO.getGamesByUserId(userId);
		List<String> userGameList = new ArrayList<>();
		for (Integer gameId : userGames) {
			userGameList.add(gamesDAO.getByIndex(gameId).getTitle());
		}
		System.out.println(userGameList.toString());
		return userGameList;
	}
	
}
