package com.capgemini.alewandowski.interfacesDAO;

import java.util.List;

import com.capgemini.alewandowski.entities.GameResult;

public interface GamesHistoryDAO {
	void addRecord(GameResult gameResult);
	List<GameResult> getRecordByGame(int gameId);
	List<GameResult> getRecordByUser(int userId);
	List<GameResult> getHistory();
}
