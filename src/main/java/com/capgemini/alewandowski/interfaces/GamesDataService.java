package com.capgemini.alewandowski.interfaces;

import java.util.List;

import com.capgemini.alewandowski.ENUMS.DIFFICULTY;
import com.capgemini.alewandowski.ENUMS.GAME_TYPE;
import com.capgemini.alewandowski.entities.Game;

public interface GamesDataService {
	Game createGame(String title, boolean isOnePlayable);
	Game createGame(int gameId, String title, int minPlayers, 
			int maxPlayers, boolean isOnePlayable, 
			DIFFICULTY difficultLevel, int minRecuiedForOnePlay, GAME_TYPE type);
	
	void addGame(int userId, int gameId);
	void editGame(int gameId, Game editedGame);
	
	
	void showDetails(int gameId);
	List<String> getListOfGames();

}
