package com.capgemini.alewandowski.interfaces;

import java.util.List;

import com.capgemini.alewandowski.ENUMS.DIFFICULTY;
import com.capgemini.alewandowski.ENUMS.GAME_TYPE;
import com.capgemini.alewandowski.entities.Game;
import com.capgemini.alewandowski.entities.User;

public interface GamesDataService {
	Game createGame(String title, boolean isOnePlayable);
	Game createGame(int gameId, String title, int minPlayers, 
			int maxPlayers, boolean isOnePlayable, 
			DIFFICULTY difficultLevel, int minRecuiedForOnePlay, GAME_TYPE type);
	
	void addGame(int userId, int gameId);
	
	void editGameTitle(int gameId, String newTitle);
	void editGameMinPlayers(int gameId, int minPlayers);
	void editGameMaxPlayers(int gameId, int maxPlayers);
	void editGameIsOnePlay(int gameId, boolean isOne);
	void editGameDifficulty(int gameId, DIFFICULTY difficulty);
	void editGameTime(int gameId, int min);
	void editGameType(int gameId, GAME_TYPE type);
	
	void showDetails(int gameId);
	List<String> getListOfGames();

}
