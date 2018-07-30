package com.capgemini.alewandowski.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.alewandowski.entities.GameResult;
import com.capgemini.alewandowski.interfaces.GamesHistoryService;
import com.capgemini.alewandowski.interfacesDAO.GamesHistoryDAO;
import com.capgemini.alewandowski.interfacesDAO.UserStatsDAO;

@Service
public class GamesHistoryServiceImpl implements GamesHistoryService {
	
	@Autowired
	UserStatsDAO userStatsDAO;
	
	@Autowired
	GamesHistoryDAO gamesHistoryDAO;

	@Override
	public GameResult addRecord(GameResult gameResult) {
		GameResult record = gameResult;
		updateStats(record);
		saveRecord(record);
		return null;
	}
	
	private void updateStats(GameResult gameResult){
		int pointForWin = 3;
		int pointForDraw = 2;
		int pointForLose = 1;
		GameResult record = gameResult;
		List<Integer> players = record.getPlayedUsersId();
		int winner = record.getUserWon();
		if (winner!=0) {
			userStatsDAO.addWin(winner);
			userStatsDAO.addPoints(winner, pointForWin);
			for (Integer userId : players) {
				if (userId!=winner) {
					userStatsDAO.addLose(userId);
					userStatsDAO.addPoints(userId, pointForLose);
				}								
			}
		}else{
			for (Integer userId : players) {
				userStatsDAO.addDraw(userId);
				userStatsDAO.addPoints(userId, pointForDraw);								
			}
		}
	}
	
	private void saveRecord(GameResult gameResult){
		gamesHistoryDAO.addRecord(gameResult);
	}
}
