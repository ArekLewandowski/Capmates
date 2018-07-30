package com.capgemini.alewandowski.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.alewandowski.entities.GameResult;
import com.capgemini.alewandowski.interfacesDAO.GamesHistoryDAO;

@Repository
public class GamesHistoryDAOImpl implements GamesHistoryDAO{
	List<GameResult> history = new ArrayList<>();

	@Override
	public void addRecord(GameResult gameResult) {
		history.add(gameResult);
	}

	@Override
	public List<GameResult> getRecordByGame(int gameId) {
		List<GameResult> gResult = new ArrayList<>();
		for (GameResult gameResult : history) {
			if (gameResult.getPlayedGame().getGameId()==gameId) {
				gResult.add(gameResult);
			}
		}
		return gResult;
	}

	@Override
	public List<GameResult> getRecordByUser(int userId) {
		List<GameResult> userhistory = new ArrayList<>();
		for (GameResult gameResult : history) {
			if(gameResult.getPlayedUsersId().contains((Integer)userId)){
				userhistory.add(gameResult);
			}
		}
		return userhistory;
	}

	@Override
	public List<GameResult> getHistory() {
		return history;
	}

}
