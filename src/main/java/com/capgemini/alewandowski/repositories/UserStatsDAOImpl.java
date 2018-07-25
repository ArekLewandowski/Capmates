package com.capgemini.alewandowski.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.alewandowski.ENUMS.LEVEL;
import com.capgemini.alewandowski.entities.User;
import com.capgemini.alewandowski.entities.UserStats;
import com.capgemini.alewandowski.interfaces.UserStatsDAO;

@Repository
public class UserStatsDAOImpl implements UserStatsDAO{
	List<UserStats> userStatsList;
	
	public UserStatsDAOImpl() {
		super();
		this.userStatsList = new ArrayList<>();
	}
	@Override
	public UserStats addNewUser(UserStats userStats) {
		userStatsList.add(userStats);
		return userStats;
	}
	@Override
	public void deleteStatsOfUser(int userid) {
		userStatsList.remove(userid);		
	}

	@Override
	public int checkPoints(int userId) {
		int userPoints = userStatsList.get(userId).getCurrentLevelPoints();
		return userPoints;
	}

	@Override
	public LEVEL checkLevel(int userId) {
		LEVEL level;
		int userPoints = userStatsList.get(userId).getCurrentLevelPoints();
		if (userPoints<20) {
			level = LEVEL.NOVICE;
		}else if(userPoints<40) {
			level = LEVEL.BEGINNER;
		}else if(userPoints<60){
			level = LEVEL.INTERMEDIATE;
		}else if(userPoints<80){
			level = LEVEL.ADVANCED;
		}else if(userPoints<100){
			level = LEVEL.EXPERT;
		}else{
			level = LEVEL.WORLDCLASS;
		}
		return level;
	}
	
	@Override
	public List<User> getRankingData() {
		List<User> rankingList = null;
		return rankingList;
	}

	@Override
	public void savePoints(int userId, int addedPoints) {
		int currentPoints = userStatsList.get(userId).getCurrentLevelPoints();
		currentPoints += addedPoints;
		userStatsList.get(userId).setCurrentLevelPoints(currentPoints);
	}

}
