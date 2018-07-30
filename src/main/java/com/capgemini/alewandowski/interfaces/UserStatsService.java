package com.capgemini.alewandowski.interfaces;

import com.capgemini.alewandowski.ENUMS.LEVEL;

public interface UserStatsService {
	int getWins(int userId);
	int getDraw(int userId);
	int getLose(int userId);
	int getUserPoints(int userId);
	LEVEL getLevel(int userId);
}
