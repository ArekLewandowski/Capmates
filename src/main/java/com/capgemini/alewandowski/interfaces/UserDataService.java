package com.capgemini.alewandowski.interfaces;

import java.util.List;

import com.capgemini.alewandowski.entities.User;

public interface UserDataService {
	User addNewUser(String firstName, String lastName);
	
	User changeUserData(User user);
	
	void deleteUser(int userId);
	
	void viewInforamtion(int userId);
	
	List<String> getUsersGameList(int userId);
	

}
