package com.capgemini.alewandowski.interfaces;

import java.util.List;

import com.capgemini.alewandowski.Exceptions.NoUserIdInDataBase;
import com.capgemini.alewandowski.entities.User;

public interface UserDataService {
	User addNewUser(String firstName, String lastName);
	
	User changeUserData(User user) throws NoUserIdInDataBase;
	
	void deleteUser(int userId);
	
	void viewInforamtion(int userId) throws NoUserIdInDataBase;
	
	List<String> getUsersGameList(int userId);
	

}
