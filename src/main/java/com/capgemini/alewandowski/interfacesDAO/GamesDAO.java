package com.capgemini.alewandowski.interfacesDAO;

import java.util.List;

import com.capgemini.alewandowski.entities.Game;

public interface GamesDAO {
	
	void addToList(Game game);
	void delete(int index);
	
	List<Game> getAll();
	List<String> getListOfGames();
	Game getByIndex(int index);
	
	void editGame(int gameId, Game editedGame);

}
