package com.capgemini.alewandowski.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.alewandowski.ENUMS.LEVEL;
import com.capgemini.alewandowski.interfaces.UserStatsService;
import com.capgemini.alewandowski.interfacesDAO.UserStatsDAO;

@Service
public class UserStatsServiceImpl implements UserStatsService{

	
	@Autowired
	private UserStatsDAO userStatsDAO;

	public UserStatsServiceImpl() {
		super();
	}

	@Override
	public int getWins(int userId) {	
		return userStatsDAO.getUserStats(userId).getWon();
	}

	@Override
	public int getDraw(int userId) {
		return userStatsDAO.getUserStats(userId).getDraw();
	}

	@Override
	public int getLose(int userId) {
		return userStatsDAO.getUserStats(userId).getLost();
	}

	@Override
	public int getUserPoints(int userId) {
		return userStatsDAO.getUserStats(userId).getCurrentLevelPoints();
	}

	@Override
	public LEVEL getLevel(int userId) {
		int currentPoints = userStatsDAO.getUserStats(userId).getCurrentLevelPoints();
		LEVEL currentLevel = userStatsDAO.checkLevel(currentPoints);
		return currentLevel;
	}
		
}

