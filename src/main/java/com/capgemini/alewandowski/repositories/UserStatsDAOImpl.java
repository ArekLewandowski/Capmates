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
	List<UserStats> userStats;
	
	public UserStatsDAOImpl() {
		super();
		this.userStats = new ArrayList<>();
	}

	@Override
	public int checkPoints(int userId) {
		return userStats.get(userId).getCurrentLevelPoints();
	}

	@Override
	public LEVEL checkLevel(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> checkPlayersGames(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getRankingData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User addNewUser(UserStats userStats) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteStatsOfUser(int userid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void savePoints(int userId, int adde) {
		// TODO Auto-generated method stub
		
	}

}
