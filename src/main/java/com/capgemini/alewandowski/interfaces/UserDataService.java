package com.capgemini.alewandowski.interfaces;

import java.util.List;

import com.capgemini.alewandowski.Exceptions.NoUserIdInDataBase;
import com.capgemini.alewandowski.entities.User;

public interface UserDataService {
	User addNewUser(String firstName, String lastName);
	
	List<User> getUsers();
	
	List<User> searchUsers(String firstName, String lastName, String email) throws NoUserIdInDataBase;
	
	User changeUserData(User user) throws NoUserIdInDataBase;
	
	User deleteUser(int userId) throws NoUserIdInDataBase;
	
	User viewInforamtion(int userId) throws NoUserIdInDataBase;
	
	List<String> getUsersGameList(int userId);
	

}
