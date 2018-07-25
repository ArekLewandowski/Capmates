package com.capgemini.alewandowski.interfaces;

import java.util.List;

import com.capgemini.alewandowski.entities.User;

public interface UserBasicDAO {
	User addUser(User user);
	User getUser(int id);
	User editUser(int id, User editedUser);
	List<User> getRankingData();//id, firstname, lastname
	void deleteUser(int id);
	List<Integer> showListOfUserGames(int id);
	
}
