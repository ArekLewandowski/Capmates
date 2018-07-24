package com.capgemini.alewandowski.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.alewandowski.ENUMS.LEVEL;
import com.capgemini.alewandowski.entities.Game;
import com.capgemini.alewandowski.entities.User;

@Service
public interface UserGameStatsService {

	int checkPoints(int userId);
	
	LEVEL checkLevel(int userId);
	
	List<Game> checkPlayersGames(int userId);
	
	List<User> checkRanking();
}

