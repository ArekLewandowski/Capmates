package com.capgemini.alewandowski.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.alewandowski.ENUMS.LEVEL;
import com.capgemini.alewandowski.entities.RankingEntity;
import com.capgemini.alewandowski.entities.User;
import com.capgemini.alewandowski.entities.UserStats;
import com.capgemini.alewandowski.interfacesDAO.UserStatsDAO;

@Repository
public class UserStatsDAOImpl implements UserStatsDAO{
	List<UserStats> userStatsList;
	
	public UserStatsDAOImpl() {
		super();
		this.userStatsList = new ArrayList<>();
	}
	@Override
	public UserStats addNewUserStats(UserStats userStats) {
		userStatsList.add(userStats);
		return userStats;
	}
	@Override
	public UserStats getUserStats(int userId) {
		return userStatsList.get(userId);
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
	public List<RankingEntity> getRankingData() {
		List<RankingEntity> rankingList = new ArrayList<>();
		List<UserStats> fullList = new ArrayList<>();
		fullList.addAll(userStatsList);
		for (UserStats userStats : fullList) {
			rankingList.add(new RankingEntity(userStats.getUserId(), userStats.getCurrentLevelPoints()));
		}
		return rankingList;
	}
	@Override
	public void addWin(int userId) {
		int won = this.userStatsList.get(userId).getWon();
		won++;
		this.userStatsList.get(userId).setWon(won);
	}
	@Override
	public void addDraw(int userId) {
		int draw = this.userStatsList.get(userId).getDraw();
		draw++;
		this.userStatsList.get(userId).setDraw(draw);
		
	}
	@Override
	public void addLose(int userId) {
		int lost = this.userStatsList.get(userId).getLost();
		lost++;
		this.userStatsList.get(userId).setLost(lost);
		
	}
	@Override
	public void addPoints(int userId, int points) {
		int currentPoints = this.userStatsList.get(userId).getCurrentLevelPoints();
		currentPoints += points;
		this.userStatsList.get(userId).setCurrentLevelPoints(currentPoints);
		
	}

}
