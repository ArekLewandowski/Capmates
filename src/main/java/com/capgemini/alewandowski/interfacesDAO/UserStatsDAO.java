package com.capgemini.alewandowski.interfacesDAO;

import java.util.List;

import com.capgemini.alewandowski.ENUMS.LEVEL;
import com.capgemini.alewandowski.entities.RankingEntity;
import com.capgemini.alewandowski.entities.User;
import com.capgemini.alewandowski.entities.UserStats;

public interface UserStatsDAO {
	UserStats addNewUserStats(UserStats userStats);	
	UserStats getUserStats(int userId);
	
	void addWin(int userId);
	void addDraw(int userId);
	void addLose(int userId);
	
	void addPoints(int userId, int points);
	void deleteStatsOfUser(int userid);
	int checkPoints(int userId);	
	LEVEL checkLevel(int userId);
	List<RankingEntity> getRankingData();	
}
