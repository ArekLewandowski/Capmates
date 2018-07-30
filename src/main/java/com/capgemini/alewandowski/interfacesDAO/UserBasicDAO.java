package com.capgemini.alewandowski.interfacesDAO;

import java.util.List;

import com.capgemini.alewandowski.Exceptions.NoUserIdInDataBase;
import com.capgemini.alewandowski.entities.RankingEntity;
import com.capgemini.alewandowski.entities.User;

public interface UserBasicDAO {
	
	User addUser(User user);
	
	List<User> getUsers();
	
	User getUser(int id) throws NoUserIdInDataBase;
	
	User getUserByListId(int listId);
	
	List<User> search(String firstName, String lastName, String email);
	
	User editUser(int id, User editedUser) throws NoUserIdInDataBase;
	
	List<RankingEntity> getRankingData();//id, firstname, lastname
	
	void deleteUser(int id);	
}
