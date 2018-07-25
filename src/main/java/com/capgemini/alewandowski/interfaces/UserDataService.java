package com.capgemini.alewandowski.interfaces;

import java.util.List;

import com.capgemini.alewandowski.entities.User;

public interface UserDataService {
	User addNewUser(String firstName, String lastName);
	
	User changeUserData(int userId,
			String firstName, 
			String lastName, 
			String email, 
			String password, 
			String lifeMotto);
	
	void deleteUser(int userId);
	
	void viewInforamtion(int userId);
	
	List<String> getUsersGameList(int userId);
	

}
