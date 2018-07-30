package com.capgemini.alewandowski.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.alewandowski.Exceptions.NoUserIdInDataBase;
import com.capgemini.alewandowski.entities.User;
import com.capgemini.alewandowski.entities.UserStats;
import com.capgemini.alewandowski.interfaces.UserDataService;
import com.capgemini.alewandowski.interfacesDAO.GamesDAO;
import com.capgemini.alewandowski.interfacesDAO.UserBasicDAO;
import com.capgemini.alewandowski.interfacesDAO.UserGamesDAO;
import com.capgemini.alewandowski.interfacesDAO.UserStatsDAO;

@Service
public class UserDataServiceImpl implements UserDataService{

	@Autowired
	private UserBasicDAO userBasicDAO;
	
	@Autowired
	private UserStatsDAO userStatsDAO;
	
	@Autowired
	private GamesDAO gamesDAO;
	
	@Autowired
	private UserGamesDAO userGamesDAO;	
	

	public UserDataServiceImpl() {
		super();
		System.out.println("User service");
	}
	
	
	@Override
	public User addNewUser(String firstName, String lastName) {
		User newUser = new User(firstName, lastName);
		UserStats userStats = new UserStats();
		userStats.setCurrentLevelPoints(0);	
		userBasicDAO.addUser(newUser);
		userStatsDAO.addNewUserStats(userStats);		
		return newUser;
	}

	@Override
	public User changeUserData(User user) throws NoUserIdInDataBase {
		User editedUser = userBasicDAO.editUser(user.getUserId(), user);
		return editedUser;
	}
	@Override
	public User viewInforamtion(int userId) throws NoUserIdInDataBase {
		User user = userBasicDAO.getUser(userId);
		System.out.println("Id: "+user.getUserId());
		System.out.println("First Name: "+user.getFirstName());
		System.out.println("Last Name: "+user.getLastName());
		System.out.println("Email: "+user.getEmailAddres());
		System.out.println("Life motto: "+user.getLifeMotto());
		return user;
	}

	@Override
	public User deleteUser(int userId) throws NoUserIdInDataBase {
		User deletedUser = userBasicDAO.getUser(userId);
		userBasicDAO.deleteUser(userId);
		userStatsDAO.deleteStatsOfUser(userId);
		return deletedUser;
	}

	@Override
	public List<User> getUsers() {
		return userBasicDAO.getUsers();
	}
	
	@Override
	public List<User> searchUsers(String firstName, String lastName, String email) throws NoUserIdInDataBase {
		
		List<User> comboList = userBasicDAO.search(firstName, lastName, email);
		return comboList;
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
