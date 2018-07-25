package com.capgemini.alewandowski.interfacesDAO;

import java.util.List;

import com.capgemini.alewandowski.entities.RankingEntity;
import com.capgemini.alewandowski.entities.User;

public interface UserBasicDAO {
	User addUser(User user);
	User getUser(int id);
	User editUser(int id, User editedUser);
	List<RankingEntity> getRankingData();//id, firstname, lastname
	void deleteUser(int id);	
}
