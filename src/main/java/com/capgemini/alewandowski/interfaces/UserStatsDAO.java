package com.capgemini.alewandowski.interfaces;

import java.util.List;

import com.capgemini.alewandowski.ENUMS.LEVEL;
import com.capgemini.alewandowski.entities.User;
import com.capgemini.alewandowski.entities.UserStats;

public interface UserStatsDAO {
	User addNewUser(UserStats userStats);	
	void deleteStatsOfUser(int userid);
	//UserDataEdit
	void savePoints(int userId, int adde);
	//UserDataView
	int checkPoints(int userId);	
	LEVEL checkLevel(int userId);	
	List<Integer> checkPlayersGames(int userId);
	List<User> getRankingData();


	
}
