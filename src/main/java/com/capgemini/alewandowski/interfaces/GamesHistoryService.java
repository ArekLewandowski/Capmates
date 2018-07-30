package com.capgemini.alewandowski.interfaces;

import com.capgemini.alewandowski.entities.GameResult;

public interface GamesHistoryService {
	GameResult addRecord(GameResult gameResult);
}
